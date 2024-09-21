package itstep.learning.debug;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DebugInfoHolder {
    private static final String SESSION_ATTRIBUTE = "debugInfoHolder";
    private final List<String> messages = new CopyOnWriteArrayList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void clear() {
        messages.clear();
    }

    public static synchronized  DebugInfoHolder getOrCreate(HttpSession session) {
        DebugInfoHolder holder = (DebugInfoHolder) session.getAttribute(SESSION_ATTRIBUTE);
        if (holder == null) {
            holder = new DebugInfoHolder();
            session.setAttribute(SESSION_ATTRIBUTE, holder);
        }
        return holder;
    }
}