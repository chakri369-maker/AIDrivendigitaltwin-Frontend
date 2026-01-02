-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2025 at 05:51 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `digital_twin`
--

-- --------------------------------------------------------

--
-- Table structure for table `fashion_trends`
--

CREATE TABLE `fashion_trends` (
  `id` int(11) NOT NULL,
  `fashion_keyword` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `industry_data`
--

CREATE TABLE `industry_data` (
  `id` int(11) NOT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `metric` varchar(255) DEFAULT NULL,
  `value` float DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `retail_data`
--

CREATE TABLE `retail_data` (
  `id` int(11) NOT NULL,
  `product` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `retail_data`
--

INSERT INTO `retail_data` (`id`, `product`, `category`, `price`, `rating`, `source`, `timestamp`) VALUES
(1, 'Amazon Great Indian Festival 2025 ends 20 October, shop last-minute deals - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(2, 'Amazon India Allocates Rs 2,000 Cr to Enhance Tech and Workforce - Indian Retailer', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(3, 'Amazon and Flipkart showcase GST deals as festival shopping begins - Business Standard', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(4, 'Amazon announces the launch of Rufus, a new generative AI-powered conversational shopping assistant, in India - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(5, 'Amazon launches a low-price standalone shopping app, Amazon Bazaar, in over a dozen markets - TechCrunch', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(6, 'Retail India News: Amazon India Expands Operations to Strengthen Festive Season Deliveries - Indian Retailer', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(7, 'Prime Day 2025: Top deals, new product launches at fastest delivery speeds - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(8, 'India at Prime Speed: Samir Kumar and the New Age of Amazon - ET Retail', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(9, 'Amazon Haul heading to India? Low-cost online retail store may fill the Temu-Shein market gap but increase textile waste - theweek.in', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(10, 'Amazon to launch quick commerce deliveries in India amid boom in segment - ET Retail', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(11, 'Amazon Prime Day deals 2025: Up to 75% off on electronics, apparels and more - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(12, 'Amazon Bazaar: Your destination for ultra-affordable shopping at ‘crazy low prices’ - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(13, 'Amazon Prime Day 2025: Exclusive deals coming to India July 12-14 - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(14, 'Great Indian Festival 2024 creates new records for customer visits, new launches and seller success - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(15, 'Amazon Prime Day 2025: Top products from India\'s record-breaking sale - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(16, 'Get the best offers on smartphones, laptops, tablets, and headphones this Amazon Great Indian Festival 2025 - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(17, 'Samsung, Xiaomi, 3 others colluding with Amazon, Flipkart: Report - The Times of India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(18, 'Amazon launches first online shopping site in India - BBC', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(19, 'Shop big at Amazon’s Great Freedom Festival: Check out deals across electronics, fashion, beauty and more - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(20, 'Shop GST savings during Amazon Great Indian Festival 2025 - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(21, 'Amazon to launch quick commerce deliveries in India amid boom in segment - The Economic Times', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(22, 'Amazon Great Indian Festival 2024: All top deals revealed - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(23, 'Amazon copied products and rigged search results to promote its own brands, documents show - Reuters', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(24, 'Amazon India launches affordable multi-designer brand - RIVER - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(25, 'Exclusive: India accuses Samsung, Xiaomi of colluding with Amazon, Flipkart - Reuters', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(26, 'Amazon launches Kisan Store for farmers on Amazon.in - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(27, 'How Amazon India is Bringing International Beauty Brands to Every Pin Code - Indian Retailer', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(28, 'India’s richest man can’t crack e-commerce, even with Shein - Rest of World', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(29, 'Competition heats up in quick commerce as Amazon takes on Zepto, Blinkit with 10-min dash - ET BrandEquity', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(30, 'The top deals to shop during Amazon Great Indian Festival 2023 - About Amazon India', 'Retail Trend', 0, 0, 'Google News (Amazon)', '2025-12-13 12:55:21'),
(31, 'Prime Day 2025: Top deals, new product launches at fastest delivery speeds - About Amazon India', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(32, 'Amazon India Prime Day 2025 sale dates announced: New launches, discounts and more - financialexpress.com', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(33, 'Amazon India Prime Day 2025 sale dates announced: Offers discounts, and more about first ever 3-day celeb - The Times of India', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(34, 'Amazon Prime Day sale 2025 starts July 12: 72 Hours of exclusive deals, new launches, and fast deliveries - livemint.com', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(35, 'Amazon Prime Day 2025 in India to run for 72 hours from July 12 with new launches, major discounts; check details here - Fortune India', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(36, 'Amazon Prime Day 2025 is LIVE- Save Big on Everyday Essentials, Groceries & More - The Economic Times', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(37, 'Amazon India Prime Day 2025: Check out deals on iPhone 15, smart TVs, and more - The Indian Express', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(38, 'Amazon Great Indian Festival 2025: Over 38 crore visits, 30000 new product launches, and more - FoneArena.com', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(39, 'Amazon and Flipkart showcase GST deals as festival shopping begins - Business Standard', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(40, 'Amazon Great Indian Festival vs Flipkart Big Billion Days 2025: Important dates, best deals, bank offers and more | Technology News - Hindustan Times', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(41, 'Amazon Prime Day Sale 2025: These 8 products to be launched during the sale - Moneycontrol', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(42, 'Mark Your Calendar: Amazon Great Indian Festival Sale 2025 Begins on 23rd September - thedailyjagran.com', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(43, 'Amazon Prime Day 2025 Sale: Discounts on Electronics and Bank Offers Revealed - Gadgets 360', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(44, 'Amazon to focus on small towns this year with three-day Prime Day sale - livemint.com', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(45, 'Amazon Prime Day Launches 2025 is LIVE - Best deals on 400+ New Launches from top brands - The Economic Times', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(46, 'Amazon announces dates for biggest sale of the year, Prime Day 2025: Up to 80% discount and 6 other thing - The Times of India', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(47, 'Amazon Great Indian Festival 2025 starts September 23: Deals on phones, flights, and more - The Indian Express', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(48, 'iPhone 15 at ₹46999 in Amazon sale: Should you buy it? Best Android mobile alternatives | Hindustan Times - Hindustan Times', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(49, 'Amazon Great Indian Festival 2025: Deals on Smartphones, Laptops and more - FoneArena.com', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(50, 'Amazon Prime Day 2025 is LIVE– Best Offers from Leading Brands. WISHLIST NOW! - The Economic Times', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(51, 'Amazon Prime Day 2025: Dates, discounts, deals and more - Moneycontrol', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(52, 'Amazon Great Indian Festival 2025: Epic Laptop & Tablet Deals to Supercharge your Life - The Economic Times', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(53, 'Amazon Prime Day 2025 sale dates, discounts, bank offers and other details revealed - digit.in', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(54, 'Amazon Prime Day 2025 is LIVE- Deals on Laptops, Tablets, Headphones and more with up to 80% off - The Economic Times', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(55, 'Amazon Great Indian Festival & Flipkart Big Billion Days Sale 2025: Start Date, Top Deals, Discounts & Offers - Goodreturns', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(56, 'Which Amazon Great Indian Festival 2025 Deals Are You Waiting for The Most? - Herzindagi', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(57, 'Amazon Great Freedom Festival Sale set to begin on August 1: Check deals, bank discounts and early prime access - financialexpress.com', 'Retail Trend', 8, 4, 'Google News', '2025-12-13 12:57:10'),
(58, 'Amazon Republic Day Sale is LIVE: Grab deals on OnePlus 13 series, Redmi 14C, and other newly launched phones | Hindustan Times - Hindustan Times', 'Retail Trend', 9, 4, 'Google News', '2025-12-13 12:57:10'),
(59, 'Amazon Republic Day Deals: Dreame Tech Smart Cleaning & Personal Care on Amazon - The Hans India', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10'),
(60, 'Amazon Great Indian Festival 2025 ends 20 October, shop last-minute deals - About Amazon India', 'Retail Trend', 5, 4, 'Google News', '2025-12-13 12:57:10');

-- --------------------------------------------------------

--
-- Table structure for table `technology_trends`
--

CREATE TABLE `technology_trends` (
  `id` int(11) NOT NULL,
  `tech_keyword` varchar(255) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `technology_trends`
--

INSERT INTO `technology_trends` (`id`, `tech_keyword`, `score`, `source`, `timestamp`) VALUES
(1, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 12, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(2, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 5, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(3, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 6, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(4, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 14, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(5, 'The market has ‘switched’ and founders have the power now, VCs say', 10, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(6, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 13, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(7, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 12, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(8, 'Google’s AI try-on feature for clothes now works with just a selfie', 11, 'TechCrunch RSS', '2025-12-12 09:41:15'),
(9, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 14, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(10, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 9, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(11, 'Rivian’s AI assistant is coming to its EVs in early 2026', 8, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(12, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 8, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(13, 'Runway releases its first world model, adds native audio to latest video model', 6, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(14, 'Ford and SK On are ending their US battery joint venture', 7, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(15, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 15, 'TechCrunch RSS', '2025-12-12 09:41:16'),
(16, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 12, 'TechCrunch RSS', '2025-12-12 09:44:38'),
(17, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 15, 'TechCrunch RSS', '2025-12-12 09:44:38'),
(18, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 15, 'TechCrunch RSS', '2025-12-12 09:44:38'),
(19, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 5, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(20, 'The market has ‘switched’ and founders have the power now, VCs say', 13, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(21, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 5, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(22, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 9, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(23, 'Google’s AI try-on feature for clothes now works with just a selfie', 12, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(24, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 10, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(25, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 5, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(26, 'Rivian’s AI assistant is coming to its EVs in early 2026', 14, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(27, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 5, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(28, 'Runway releases its first world model, adds native audio to latest video model', 9, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(29, 'Ford and SK On are ending their US battery joint venture', 14, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(30, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 10, 'TechCrunch RSS', '2025-12-12 09:44:39'),
(31, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 7, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(32, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 13, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(33, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 11, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(34, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 13, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(35, 'The market has ‘switched’ and founders have the power now, VCs say', 10, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(36, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(37, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 9, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(38, 'Google’s AI try-on feature for clothes now works with just a selfie', 9, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(39, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 10, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(40, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 11, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(41, 'Rivian’s AI assistant is coming to its EVs in early 2026', 6, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(42, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 7, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(43, 'Runway releases its first world model, adds native audio to latest video model', 12, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(44, 'Ford and SK On are ending their US battery joint venture', 9, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(45, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 13, 'TechCrunch RSS', '2025-12-12 09:45:46'),
(46, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 15, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(47, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 11, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(48, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 14, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(49, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 12, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(50, 'The market has ‘switched’ and founders have the power now, VCs say', 5, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(51, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 6, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(52, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 7, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(53, 'Google’s AI try-on feature for clothes now works with just a selfie', 14, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(54, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 13, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(55, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 9, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(56, 'Rivian’s AI assistant is coming to its EVs in early 2026', 8, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(57, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 11, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(58, 'Runway releases its first world model, adds native audio to latest video model', 7, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(59, 'Ford and SK On are ending their US battery joint venture', 6, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(60, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 8, 'TechCrunch RSS', '2025-12-12 09:48:07'),
(61, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 6, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(62, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 15, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(63, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 14, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(64, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 7, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(65, 'The market has ‘switched’ and founders have the power now, VCs say', 7, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(66, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 15, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(67, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 10, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(68, 'Google’s AI try-on feature for clothes now works with just a selfie', 15, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(69, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 14, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(70, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 15, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(71, 'Rivian’s AI assistant is coming to its EVs in early 2026', 11, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(72, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 11, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(73, 'Runway releases its first world model, adds native audio to latest video model', 11, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(74, 'Ford and SK On are ending their US battery joint venture', 14, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(75, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 7, 'TechCrunch RSS', '2025-12-12 09:49:25'),
(76, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 15, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(77, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 12, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(78, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 10, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(79, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 11, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(80, 'The market has ‘switched’ and founders have the power now, VCs say', 7, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(81, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 13, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(82, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 10, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(83, 'Google’s AI try-on feature for clothes now works with just a selfie', 6, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(84, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 6, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(85, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 14, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(86, 'Rivian’s AI assistant is coming to its EVs in early 2026', 13, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(87, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 9, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(88, 'Runway releases its first world model, adds native audio to latest video model', 11, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(89, 'Ford and SK On are ending their US battery joint venture', 14, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(90, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 12, 'TechCrunch RSS', '2025-12-12 09:50:28'),
(91, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 13, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(92, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 14, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(93, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 5, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(94, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 13, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(95, 'The market has ‘switched’ and founders have the power now, VCs say', 15, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(96, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(97, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 7, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(98, 'Google’s AI try-on feature for clothes now works with just a selfie', 9, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(99, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 7, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(100, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 15, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(101, 'Rivian’s AI assistant is coming to its EVs in early 2026', 7, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(102, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 12, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(103, 'Runway releases its first world model, adds native audio to latest video model', 12, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(104, 'Ford and SK On are ending their US battery joint venture', 10, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(105, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 5, 'TechCrunch RSS', '2025-12-12 09:51:34'),
(106, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 15, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(107, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 15, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(108, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 15, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(109, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 14, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(110, 'The market has ‘switched’ and founders have the power now, VCs say', 10, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(111, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(112, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 10, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(113, 'Google’s AI try-on feature for clothes now works with just a selfie', 6, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(114, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 8, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(115, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 9, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(116, 'Rivian’s AI assistant is coming to its EVs in early 2026', 10, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(117, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 10, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(118, 'Runway releases its first world model, adds native audio to latest video model', 7, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(119, 'Ford and SK On are ending their US battery joint venture', 11, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(120, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 15, 'TechCrunch RSS', '2025-12-12 09:54:19'),
(121, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 10, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(122, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 9, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(123, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 15, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(124, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 5, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(125, 'The market has ‘switched’ and founders have the power now, VCs say', 6, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(126, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 11, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(127, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 12, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(128, 'Google’s AI try-on feature for clothes now works with just a selfie', 10, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(129, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 8, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(130, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 10, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(131, 'Rivian’s AI assistant is coming to its EVs in early 2026', 6, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(132, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 8, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(133, 'Runway releases its first world model, adds native audio to latest video model', 8, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(134, 'Ford and SK On are ending their US battery joint venture', 15, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(135, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 14, 'TechCrunch RSS', '2025-12-12 09:57:44'),
(136, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 6, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(137, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 13, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(138, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 7, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(139, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 6, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(140, 'The market has ‘switched’ and founders have the power now, VCs say', 13, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(141, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(142, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 8, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(143, 'Google’s AI try-on feature for clothes now works with just a selfie', 7, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(144, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 6, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(145, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 10, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(146, 'Rivian’s AI assistant is coming to its EVs in early 2026', 5, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(147, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 13, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(148, 'Runway releases its first world model, adds native audio to latest video model', 5, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(149, 'Ford and SK On are ending their US battery joint venture', 11, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(150, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 8, 'TechCrunch RSS', '2025-12-12 09:58:37'),
(151, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 9, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(152, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 8, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(153, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 10, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(154, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 7, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(155, 'The market has ‘switched’ and founders have the power now, VCs say', 8, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(156, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(157, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 8, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(158, 'Google’s AI try-on feature for clothes now works with just a selfie', 9, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(159, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 12, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(160, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 6, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(161, 'Rivian’s AI assistant is coming to its EVs in early 2026', 9, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(162, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 10, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(163, 'Runway releases its first world model, adds native audio to latest video model', 7, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(164, 'Ford and SK On are ending their US battery joint venture', 15, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(165, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 7, 'TechCrunch RSS', '2025-12-12 09:59:14'),
(166, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 7, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(167, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 11, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(168, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 13, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(169, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 14, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(170, 'The market has ‘switched’ and founders have the power now, VCs say', 9, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(171, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 10, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(172, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 7, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(173, 'Google’s AI try-on feature for clothes now works with just a selfie', 15, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(174, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 15, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(175, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 10, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(176, 'Rivian’s AI assistant is coming to its EVs in early 2026', 13, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(177, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 15, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(178, 'Runway releases its first world model, adds native audio to latest video model', 7, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(179, 'Ford and SK On are ending their US battery joint venture', 6, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(180, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 6, 'TechCrunch RSS', '2025-12-12 10:05:27'),
(181, 'World launches its ‘super app,’ including crypto pay and encrypted chat features', 14, 'TechCrunch RSS', '2025-12-12 10:07:21'),
(182, 'Stanford’s star reporter takes on Silicon Valley’s ‘money-soaked’ startup culture', 7, 'TechCrunch RSS', '2025-12-12 10:07:21'),
(183, 'Google launched its deepest AI research agent yet — on the same day OpenAI dropped GPT-5.2', 9, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(184, '1X struck a deal to send its ‘home’ humanoids to factories and warehouses', 9, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(185, 'The market has ‘switched’ and founders have the power now, VCs say', 6, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(186, 'Epic Games’ Fortnite is back in US Google Play Store, as court partially reverses restrictions it won on iOS', 11, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(187, 'Disney hits Google with cease-and-desist claiming ‘massive’ copyright infringement', 8, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(188, 'Google’s AI try-on feature for clothes now works with just a selfie', 5, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(189, 'OpenAI fires back at Google with GPT-5.2 after ‘code red’ memo', 5, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(190, 'Google debuts ‘Disco,’ a Gemini-powered tool for making web apps from browser tabs', 12, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(191, 'Rivian’s AI assistant is coming to its EVs in early 2026', 10, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(192, 'Rivian goes big on autonomy, with custom silicon, lidar, and a hint at robotaxis', 12, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(193, 'Runway releases its first world model, adds native audio to latest video model', 11, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(194, 'Ford and SK On are ending their US battery joint venture', 15, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(195, 'Disney signs deal with OpenAI to allow Sora to generate AI videos featuring its characters', 15, 'TechCrunch RSS', '2025-12-12 10:07:22'),
(196, 'A comprehensive list of 2025 tech layoffs', 13, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(197, 'Riding onboard with Rivian’s race to autonomy', 10, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(198, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 8, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(199, 'Google and Apple roll out emergency security updates after zero-day attacks', 12, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(200, 'OK, what’s going on with LinkedIn’s algo?', 15, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(201, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 11, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(202, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 11, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(203, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 9, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(204, 'Google Translate now lets you hear real-time translations in your headphones', 14, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(205, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 7, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(206, 'Home Depot exposed access to internal systems for a year, says researcher', 8, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(207, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 11, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(208, 'Flaw in photo booth maker’s website exposes customers’ pictures', 15, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(209, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 12, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(210, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 13, 'TechCrunch RSS', '2025-12-13 10:16:55'),
(211, 'A comprehensive list of 2025 tech layoffs', 13, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(212, 'Riding onboard with Rivian’s race to autonomy', 14, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(213, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 10, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(214, 'Google and Apple roll out emergency security updates after zero-day attacks', 7, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(215, 'OK, what’s going on with LinkedIn’s algo?', 15, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(216, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 9, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(217, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 9, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(218, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 11, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(219, 'Google Translate now lets you hear real-time translations in your headphones', 12, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(220, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 6, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(221, 'Home Depot exposed access to internal systems for a year, says researcher', 8, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(222, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 14, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(223, 'Flaw in photo booth maker’s website exposes customers’ pictures', 11, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(224, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 5, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(225, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 5, 'TechCrunch RSS', '2025-12-13 12:33:35'),
(226, 'A comprehensive list of 2025 tech layoffs', 15, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(227, 'Riding onboard with Rivian’s race to autonomy', 10, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(228, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 8, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(229, 'Google and Apple roll out emergency security updates after zero-day attacks', 11, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(230, 'OK, what’s going on with LinkedIn’s algo?', 15, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(231, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 8, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(232, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 7, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(233, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 13, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(234, 'Google Translate now lets you hear real-time translations in your headphones', 10, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(235, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 14, 'TechCrunch RSS', '2025-12-13 12:45:39'),
(236, 'Home Depot exposed access to internal systems for a year, says researcher', 6, 'TechCrunch RSS', '2025-12-13 12:45:40'),
(237, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 11, 'TechCrunch RSS', '2025-12-13 12:45:40'),
(238, 'Flaw in photo booth maker’s website exposes customers’ pictures', 15, 'TechCrunch RSS', '2025-12-13 12:45:40'),
(239, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 11, 'TechCrunch RSS', '2025-12-13 12:45:40'),
(240, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 11, 'TechCrunch RSS', '2025-12-13 12:45:40'),
(241, 'A comprehensive list of 2025 tech layoffs', 8, 'TechCrunch RSS', '2025-12-13 12:51:57'),
(242, 'Riding onboard with Rivian’s race to autonomy', 7, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(243, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 13, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(244, 'Google and Apple roll out emergency security updates after zero-day attacks', 5, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(245, 'OK, what’s going on with LinkedIn’s algo?', 13, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(246, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 15, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(247, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 8, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(248, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 15, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(249, 'Google Translate now lets you hear real-time translations in your headphones', 9, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(250, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 15, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(251, 'Home Depot exposed access to internal systems for a year, says researcher', 15, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(252, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 13, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(253, 'Flaw in photo booth maker’s website exposes customers’ pictures', 8, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(254, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 12, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(255, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 11, 'TechCrunch RSS', '2025-12-13 12:51:58'),
(256, 'A comprehensive list of 2025 tech layoffs', 5, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(257, 'Riding onboard with Rivian’s race to autonomy', 15, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(258, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 9, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(259, 'Google and Apple roll out emergency security updates after zero-day attacks', 15, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(260, 'OK, what’s going on with LinkedIn’s algo?', 8, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(261, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 5, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(262, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 15, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(263, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 14, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(264, 'Google Translate now lets you hear real-time translations in your headphones', 10, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(265, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 15, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(266, 'Home Depot exposed access to internal systems for a year, says researcher', 14, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(267, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 14, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(268, 'Flaw in photo booth maker’s website exposes customers’ pictures', 7, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(269, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 10, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(270, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 12, 'TechCrunch RSS', '2025-12-13 12:52:32'),
(271, 'A comprehensive list of 2025 tech layoffs', 13, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(272, 'Riding onboard with Rivian’s race to autonomy', 9, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(273, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 12, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(274, 'Google and Apple roll out emergency security updates after zero-day attacks', 10, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(275, 'OK, what’s going on with LinkedIn’s algo?', 15, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(276, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 7, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(277, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 10, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(278, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 6, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(279, 'Google Translate now lets you hear real-time translations in your headphones', 11, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(280, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 13, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(281, 'Home Depot exposed access to internal systems for a year, says researcher', 11, 'TechCrunch RSS', '2025-12-13 12:55:17'),
(282, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 10, 'TechCrunch RSS', '2025-12-13 12:55:18'),
(283, 'Flaw in photo booth maker’s website exposes customers’ pictures', 14, 'TechCrunch RSS', '2025-12-13 12:55:18'),
(284, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 14, 'TechCrunch RSS', '2025-12-13 12:55:18'),
(285, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 12, 'TechCrunch RSS', '2025-12-13 12:55:18'),
(286, 'A comprehensive list of 2025 tech layoffs', 12, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(287, 'Riding onboard with Rivian’s race to autonomy', 8, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(288, 'With iOS 26.2, Apple lets you roll back Liquid Glass again — this time on the Lock Screen', 13, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(289, 'Google and Apple roll out emergency security updates after zero-day attacks', 9, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(290, 'OK, what’s going on with LinkedIn’s algo?', 5, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(291, 'Microsoft buys 3.6M metric tons of carbon removal from bioenergy plant', 10, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(292, 'Data breach at credit check giant 700Credit affects at least 5.6 million', 11, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(293, 'Trump’s AI executive order promises ‘one rulebook’ — startups may get legal limbo instead', 10, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(294, 'Google Translate now lets you hear real-time translations in your headphones', 6, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(295, 'Retro, a photo-sharing app for friends, lets you ‘time-travel’ through your camera roll', 10, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(296, 'Home Depot exposed access to internal systems for a year, says researcher', 15, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(297, 'ChatGPT: Everything you need to know about the AI-powered chatbot', 13, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(298, 'Flaw in photo booth maker’s website exposes customers’ pictures', 15, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(299, 'Zevo wants to add robotaxis to its car-share fleet, starting with newcomer Tensor', 12, 'TechCrunch RSS', '2025-12-13 12:57:08'),
(300, 'Reddit argues it isn’t like other social platforms in case against Australia’s social media ban', 9, 'TechCrunch RSS', '2025-12-13 12:57:08');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('startup_founder','investor','marketer','student_researcher') NOT NULL,
  `industries` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`industries`)),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`, `industries`, `created_at`) VALUES
(1, 'Srinivasa', 'srini@test.com', '$2y$10$pFKVmlqFXHcMb6zfLgPwrOKsoTzlE6zjfL8XCIJr5VzaaPKyQuc0m', 'startup_founder', '[\"technology\",\"health_care\"]', '2025-12-15 08:46:27');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fashion_trends`
--
ALTER TABLE `fashion_trends`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `industry_data`
--
ALTER TABLE `industry_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `retail_data`
--
ALTER TABLE `retail_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `technology_trends`
--
ALTER TABLE `technology_trends`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fashion_trends`
--
ALTER TABLE `fashion_trends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `industry_data`
--
ALTER TABLE `industry_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `retail_data`
--
ALTER TABLE `retail_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `technology_trends`
--
ALTER TABLE `technology_trends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=301;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
