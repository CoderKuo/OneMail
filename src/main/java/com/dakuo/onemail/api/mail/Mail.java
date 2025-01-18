package com.dakuo.onemail.api.mail;

import com.dakuo.onemail.api.account.Account;
import com.dakuo.onemail.interal.OneMailManager;

import java.util.List;
import java.util.UUID;

/**
 * @author INDEX
 * */
public class Mail {

    private UUID uid;

    private String title;
    private String subject; 
    private List<String> content;
    private List<Object> attachments;

    private long sendTime;
    private long readTime;
    private long expireTime;

    public Mail(String title, String subject, List<String> content, List<Object> attachments, long expireTime) {
        this.uid = UUID.randomUUID();
        this.title = title;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.sendTime = System.currentTimeMillis();
        this.readTime = -1;
        this.expireTime = expireTime;
    }

    public UUID getUid() {
        return uid;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getContent() {
        return content;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public long getSendTime() {
        return sendTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public long getExpireTime() {
        return expireTime;
    }
    
    @SuppressWarnings("unchecked")
    public <T> boolean claimAttachment(int index, Account account) {
        if (index < 0 || index >= attachments.size()) {
            return false;
        }
        Object attachment = attachments.get(index);
        if (attachment == null) {
            return false;
        }
        Class<T> type = (Class<T>) attachment.getClass();
        return OneMailManager.getAttachmentService(type).claim(account, attachment);
    }

    public boolean claimAllAttachments(Account account) {
        boolean allClaimed = true;
        for (int i = 0; i < attachments.size(); i++) {
            if (!claimAttachment(i, account)) {
                allClaimed = false;
            }
        }
        return allClaimed;
    }

}
