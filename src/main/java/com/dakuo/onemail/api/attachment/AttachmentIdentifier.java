package com.dakuo.onemail.api.attachment;

/**
 * @author Index
 * */
public class AttachmentIdentifier {
    private final String identifier;
    private final String key;

    public AttachmentIdentifier(String identifier, String key) {
        this.identifier = identifier;
        this.key = key;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getKey() {
        return key;
    }
}