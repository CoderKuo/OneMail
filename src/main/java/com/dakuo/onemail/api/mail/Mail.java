package com.dakuo.onemail.api.mail;

import com.dakuo.onemail.api.attachment.Attachment;
import com.dakuo.onemail.api.attachment.AttachmentIdentifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author INDEX
 * */
public interface Mail {

    /**
     * @return UUID 返回邮件标识符
     * */
    UUID getUID();

    /**
     * @return Option<String> 获取邮件主题
     * */
    Optional<String> getSubject();

    /**
     * @return String 返回邮件标题
     * */
    String getTitle();


    /**
     * @return List<String> 返回邮件正文
     * */
    List<String> getContent();

    /**
     * @return UUID 获取发送者UID
     * */
    UUID getSender();

    /**
     * @return List<UUID> 获取接收者UUID列表
     * */
    List<UUID> getReceivers();

    /**
     * @return Long 获取发送时间
     * */
    long getSendTime();

    /**
     * @return Optional<Long> 获取邮件读取时间
     * */
    //使用Optional，防止未读取时，读取时间不存在的情况
    Optional<Long> getReadTime();

    /**
     * @return Optional<Long> 获取邮件过期时间
     * */
    //使用Optional，处理永不过期邮件
    Optional<Long> getExpireTime();

    void setReadTime(long readTime);

    /**
     * @return List<Attachment> 返回邮件附件列表
     * */
    List<Attachment> getAttachments();

    /**
     * @param attachment 实例
     * 删除附件
     * */
    void removeAttachment(Attachment attachment);

    /**
     * @param attachment 实例
     * 添加附件
     * */
    void addAttachment(Attachment attachment);

    /**
     * 检查是否包含指定类型的附件
     * 忘了刚才怎么设计的了，脑抽一样就写上了 （
     */
    boolean hasAttachment(AttachmentIdentifier identifier);

    /**
     * @param identifier 标识符实例
     * @return List<Attachment> 返回的附件实例
     * 获取指定类型的所有附件
     */
    List<Attachment> getAttachments(AttachmentIdentifier identifier);
}
