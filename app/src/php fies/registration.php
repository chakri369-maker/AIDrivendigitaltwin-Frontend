<?php
ob_clean();
header("Content-Type: application/json; charset=UTF-8");
error_reporting(0);

include "db.php";

$raw = file_get_contents("php://input");
$data = json_decode($raw, true);

if (!is_array($data)) {
    echo json_encode([
        "status" => "error",
        "message" => "Invalid JSON input"
    ]);
    exit;
}

$name = trim($data['name'] ?? '');
$email = trim($data['email'] ?? '');
$passwordRaw = $data['password'] ?? '';
$role = trim($data['role'] ?? '');
$industries = $data['industries'] ?? [];

if ($name === '' || $email === '' || $passwordRaw === '' || $role === '') {
    echo json_encode([
        "status" => "error",
        "message" => "Missing required fields"
    ]);
    exit;
}

$password = password_hash($passwordRaw, PASSWORD_BCRYPT);
$industriesJson = json_encode($industries);

// Duplicate email check
$check = $conn->prepare("SELECT id FROM users WHERE email=?");
$check->bind_param("s", $email);
$check->execute();
$check->store_result();

if ($check->num_rows > 0) {
    echo json_encode([
        "status" => "error",
        "message" => "Email already registered"
    ]);
    exit;
}

// Insert
$stmt = $conn->prepare(
    "INSERT INTO users (name, email, password, role, industries)
     VALUES (?, ?, ?, ?, ?)"
);

$stmt->bind_param("sssss", $name, $email, $password, $role, $industriesJson);

if ($stmt->execute()) {
    echo json_encode([
        "status" => "success",
        "message" => "User registered successfully"
    ]);
} else {
    echo json_encode([
        "status" => "error",
        "message" => "Registration failed"
    ]);
}

exit;
