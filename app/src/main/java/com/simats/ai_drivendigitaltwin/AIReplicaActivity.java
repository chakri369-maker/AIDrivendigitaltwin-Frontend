package com.simats.ai_drivendigitaltwin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.adapter.ChatAdapter;
import com.simats.ai_drivendigitaltwin.model.ChatMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AIReplicaActivity extends AppCompatActivity {

    ImageView btnBack, btnSend;
    EditText etMessage;
    RecyclerView recyclerChat;
    ChatAdapter adapter;
    
    TextView chipMarketTrends, chipCompetitorAnalysis, chipConsumerInsights;
    TextView chipTechIndustry, chipRetail, chipHealthcare;
    
    List<ChatMessage> messages = new ArrayList<>();
    Handler handler = new Handler(Looper.getMainLooper());
    
    // AI Knowledge base for Digital Twin topics
    Map<String, String[]> aiResponses = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_replica);

        btnBack = findViewById(R.id.btnBack);
        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);
        recyclerChat = findViewById(R.id.recyclerChat);
        
        chipMarketTrends = findViewById(R.id.chipMarketTrends);
        chipCompetitorAnalysis = findViewById(R.id.chipCompetitorAnalysis);
        chipConsumerInsights = findViewById(R.id.chipConsumerInsights);
        chipTechIndustry = findViewById(R.id.chipTechIndustry);
        chipRetail = findViewById(R.id.chipRetail);
        chipHealthcare = findViewById(R.id.chipHealthcare);

        // Initialize AI knowledge base
        initializeAIResponses();
        
        // Add welcome message
        messages.add(new ChatMessage(
            "👋 Hello! I'm your AI Replica - a Digital Twin assistant specialized in market behavior analysis, consumer insights, and competitor tracking.\n\n" +
            "I focus on three key industries:\n" +
            "• 💻 Technology\n" +
            "• 🛒 Retail\n" +
            "• 🏥 Healthcare\n\n" +
            "How can I help you today?", false));
        
        // Setup RecyclerView
        recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatAdapter(messages);
        recyclerChat.setAdapter(adapter);

        // Back button
        btnBack.setOnClickListener(v -> finish());
        
        // Send button
        btnSend.setOnClickListener(v -> sendMessage());
        
        // Topic chips
        chipMarketTrends.setOnClickListener(v -> askTopic("What are the current market trends?"));
        chipCompetitorAnalysis.setOnClickListener(v -> askTopic("Analyze my competitors"));
        chipConsumerInsights.setOnClickListener(v -> askTopic("Give me consumer insights"));
        chipTechIndustry.setOnClickListener(v -> askTopic("Technology industry analysis"));
        chipRetail.setOnClickListener(v -> askTopic("Retail market overview"));
        chipHealthcare.setOnClickListener(v -> askTopic("Healthcare sector trends"));
    }
    
    private void initializeAIResponses() {
        // Market Trends responses
        aiResponses.put("market", new String[]{
            "📊 **Current Market Trends Analysis**\n\n" +
            "Based on our Digital Twin simulation:\n\n" +
            "**Technology Sector:**\n" +
            "• AI/ML adoption up 45% YoY\n" +
            "• Cloud services demand increasing\n" +
            "• Cybersecurity investments at all-time high\n\n" +
            "**Retail Sector:**\n" +
            "• E-commerce growth continuing at 23%\n" +
            "• Omnichannel strategies becoming essential\n" +
            "• Sustainability-focused products gaining traction\n\n" +
            "**Healthcare Sector:**\n" +
            "• Telehealth adoption stabilizing at 38%\n" +
            "• AI diagnostics tools seeing 67% growth\n" +
            "• Digital health records becoming standard",
            
            "🔍 **Market Behavior Insights**\n\n" +
            "Our AI-driven analysis shows:\n\n" +
            "1. **Consumer Spending Patterns:**\n" +
            "   - Tech gadgets: +18% Q4\n" +
            "   - Healthcare apps: +42% annually\n" +
            "   - Online retail: Steady 15% growth\n\n" +
            "2. **Emerging Opportunities:**\n" +
            "   - Voice commerce in retail\n" +
            "   - Remote patient monitoring\n" +
            "   - AI-powered customer service\n\n" +
            "Would you like me to deep-dive into any specific area?"
        });
        
        // Competitor responses
        aiResponses.put("competitor", new String[]{
            "🎯 **Competitor Analysis Report**\n\n" +
            "I've analyzed your top competitors:\n\n" +
            "**TechFlow AI** (Rank #1)\n" +
            "• Market Score: 95\n" +
            "• Recent Action: Launched new pricing tier\n" +
            "• Threat Level: High\n\n" +
            "**DataSync Pro** (Rank #2)\n" +
            "• Market Score: 89\n" +
            "• Recent Action: Expanded to healthcare vertical\n" +
            "• Threat Level: Medium\n\n" +
            "**CloudBase** (Rank #3)\n" +
            "• Market Score: 87\n" +
            "• Recent Action: Reduced pricing by 20%\n" +
            "• Threat Level: Medium\n\n" +
            "💡 **Recommendation:** Monitor TechFlow AI's pricing strategy closely.",
            
            "⚡ **Competitive Intelligence Update**\n\n" +
            "**Key Competitor Movements:**\n\n" +
            "1. **Pricing Changes:**\n" +
            "   - CloudBase: -20% (aggressive)\n" +
            "   - TechFlow AI: New tier system\n\n" +
            "2. **Product Updates:**\n" +
            "   - MarketPulse launched AI features\n" +
            "   - SecureNet expanded to healthcare\n\n" +
            "3. **Market Positioning:**\n" +
            "   - Gap identified in mid-market segment\n" +
            "   - Healthcare tech underserved\n\n" +
            "Would you like specific competitor tracking recommendations?"
        });
        
        // Consumer insights responses
        aiResponses.put("consumer", new String[]{
            "💡 **Consumer Insights Dashboard**\n\n" +
            "**Sentiment Analysis:**\n" +
            "• Positive: 65%\n" +
            "• Neutral: 25%\n" +
            "• Negative: 10%\n\n" +
            "**Top Mentioned Words:**\n" +
            "✅ Innovative, Powerful, User-friendly\n" +
            "❌ Expensive, Complex\n\n" +
            "**Recent Feedback Highlights:**\n" +
            "• \"Great product, worth every penny!\" - ProductHunt\n" +
            "• \"Excellent customer support\" - Twitter\n" +
            "• \"Steep learning curve\" - G2 Reviews\n\n" +
            "📈 Overall sentiment trending positive by +3% this month.",
            
            "🧠 **Consumer Behavior Analysis**\n\n" +
            "**Purchase Drivers:**\n" +
            "1. Price sensitivity: 42%\n" +
            "2. Feature comparison: 35%\n" +
            "3. Brand trust: 23%\n\n" +
            "**Demographics:**\n" +
            "• Tech-savvy millennials: 45%\n" +
            "• Enterprise decision makers: 35%\n" +
            "• Small business owners: 20%\n\n" +
            "**Key Insight:** Consumers want value transparency and ROI clarity."
        });
        
        // Technology industry responses
        aiResponses.put("technology", new String[]{
            "💻 **Technology Industry Analysis**\n\n" +
            "**Current State:**\n" +
            "• Market Size: $5.3T globally\n" +
            "• YoY Growth: 8.4%\n" +
            "• Top Trend: Generative AI\n\n" +
            "**Key Players Movement:**\n" +
            "• AI startups raised $45B in 2024\n" +
            "• Cloud consolidation accelerating\n" +
            "• Cybersecurity M&A active\n\n" +
            "**Opportunities:**\n" +
            "1. AI integration services\n" +
            "2. Edge computing solutions\n" +
            "3. Enterprise automation\n\n" +
            "Your Digital Twin predicts 12% sector growth next quarter."
        });
        
        // Retail responses
        aiResponses.put("retail", new String[]{
            "🛒 **Retail Market Overview**\n\n" +
            "**Market Dynamics:**\n" +
            "• E-commerce share: 22% of total retail\n" +
            "• Mobile commerce: Growing 25% annually\n" +
            "• Social commerce: New $80B opportunity\n\n" +
            "**Consumer Trends:**\n" +
            "• Sustainable products: +40% demand\n" +
            "• Same-day delivery expectation: 67%\n" +
            "• AR shopping adoption: 15%\n\n" +
            "**Competitive Landscape:**\n" +
            "• Amazon maintaining 38% share\n" +
            "• D2C brands disrupting mid-market\n" +
            "• Brick-and-mortar adopting digital\n\n" +
            "💡 Focus on omnichannel experience for best ROI."
        });
        
        // Healthcare responses
        aiResponses.put("healthcare", new String[]{
            "🏥 **Healthcare Sector Analysis**\n\n" +
            "**Digital Health Trends:**\n" +
            "• Telehealth: 38% permanent adoption\n" +
            "• AI diagnostics: 67% growth\n" +
            "• Wearables: 89M new users\n\n" +
            "**Investment Hotspots:**\n" +
            "1. Remote patient monitoring\n" +
            "2. Mental health platforms\n" +
            "3. Drug discovery AI\n\n" +
            "**Regulatory Watch:**\n" +
            "• FDA AI/ML guidance updated\n" +
            "• Data privacy requirements tightening\n\n" +
            "**Market Opportunity:** $500B digital health by 2027.\n\n" +
            "Your Digital Twin suggests focusing on compliance-first solutions."
        });
    }
    
    private void askTopic(String topic) {
        etMessage.setText(topic);
        sendMessage();
    }
    
    private void sendMessage() {
        String userMessage = etMessage.getText().toString().trim();
        if (userMessage.isEmpty()) return;
        
        // Add user message
        adapter.addMessage(new ChatMessage(userMessage, true));
        recyclerChat.scrollToPosition(messages.size() - 1);
        etMessage.setText("");
        
        // Simulate AI thinking
        handler.postDelayed(() -> {
            String response = generateAIResponse(userMessage);
            adapter.addMessage(new ChatMessage(response, false));
            recyclerChat.scrollToPosition(messages.size() - 1);
        }, 1000);
    }
    
    private String generateAIResponse(String userMessage) {
        String lowerMessage = userMessage.toLowerCase();
        
        // Match keywords to responses
        if (lowerMessage.contains("market") || lowerMessage.contains("trend")) {
            return getRandomResponse("market");
        } else if (lowerMessage.contains("competitor") || lowerMessage.contains("competition") || lowerMessage.contains("analyze")) {
            return getRandomResponse("competitor");
        } else if (lowerMessage.contains("consumer") || lowerMessage.contains("insight") || lowerMessage.contains("sentiment")) {
            return getRandomResponse("consumer");
        } else if (lowerMessage.contains("tech") || lowerMessage.contains("software") || lowerMessage.contains("ai")) {
            return getRandomResponse("technology");
        } else if (lowerMessage.contains("retail") || lowerMessage.contains("shop") || lowerMessage.contains("ecommerce")) {
            return getRandomResponse("retail");
        } else if (lowerMessage.contains("health") || lowerMessage.contains("medical") || lowerMessage.contains("hospital")) {
            return getRandomResponse("healthcare");
        } else {
            return "🤔 I can help you with:\n\n" +
                   "• **Market Trends** - Current market behavior analysis\n" +
                   "• **Competitor Analysis** - Track and analyze competitors\n" +
                   "• **Consumer Insights** - Sentiment and feedback analysis\n" +
                   "• **Industry Focus** - Technology, Retail, Healthcare\n\n" +
                   "What would you like to explore? Try asking about market trends, competitor actions, or consumer behavior in any of our focus industries.";
        }
    }
    
    private String getRandomResponse(String category) {
        String[] responses = aiResponses.get(category);
        if (responses != null && responses.length > 0) {
            return responses[new Random().nextInt(responses.length)];
        }
        return "I'm analyzing that topic. Could you provide more details?";
    }
}
