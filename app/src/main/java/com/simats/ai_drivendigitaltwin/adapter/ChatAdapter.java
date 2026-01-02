package com.simats.ai_drivendigitaltwin.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.R;
import com.simats.ai_drivendigitaltwin.model.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatMessage> messages;

    public ChatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(ChatMessage message) {
        this.messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_message, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        
        holder.txtMessage.setText(message.getMessage());
        
        if (message.isUser()) {
            // User message styling
            holder.txtAvatar.setText("U");
            holder.avatarContainer.setBackgroundColor(Color.parseColor("#3B82F6"));
            holder.messageBubble.setBackgroundResource(R.drawable.option_selected);
        } else {
            // AI message styling
            holder.txtAvatar.setText("AI");
            holder.avatarContainer.setBackgroundColor(Color.parseColor("#10B981"));
            holder.messageBubble.setBackgroundResource(R.drawable.card_bg);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout avatarContainer, messageBubble;
        TextView txtAvatar, txtMessage;

        ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarContainer = itemView.findViewById(R.id.avatarContainer);
            messageBubble = itemView.findViewById(R.id.messageBubble);
            txtAvatar = itemView.findViewById(R.id.txtAvatar);
            txtMessage = itemView.findViewById(R.id.txtMessage);
        }
    }
}
