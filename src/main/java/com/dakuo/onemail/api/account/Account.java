package com.dakuo.onemail.api.account;

import com.dakuo.onemail.api.mail.Mail;
import com.dakuo.onemail.api.mail.MailGroup;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Index
 * */
public interface Account {

    /**
     * @return UUID 获取账户UID
     * */
    UUID getId();

    /**
     * @return List<MailGroup> 获取账户所有邮件组
     * */
    List<MailGroup> getMailGroups();

    /**
     * @return Optional<MailGroup> 获取账户默认邮件组
     * */
    Optional<MailGroup> getDefaultGroup();

    /**
     * @return Optional<MailGroup> 获取账户指定邮件组
     * */
    Optional<MailGroup> getMailGroup(String groupId);


    /**
     * @param groupId String 邮件组ID
     * @param name String 邮件组名称
     * 创建欣的邮件组
     * */
    void createMailGroup(String groupId, String name);

    /**
     * @return boolean 邮件组是否删除成功
     * @param groupId String 邮件组ID
     * 删除邮件组
     * */
    boolean removeMailGroup(String groupId);

    /**
     * @param receiver Account 接收者账户
     * @param groupId String 邮件组ID
     * @param mail Mail 邮件
     * 向接收者的邮件组ID发送邮件
     * */
    void sendMail(Account receiver, String groupId, Mail mail);

    /**
     * @param receiver Account 接收者账户
     * @param mail Mail 邮件
     * 向接收者默认邮件组发送邮件
     * */
    void sendMail(Account receiver, Mail mail);

    /**
     * @param includeRead boolean 是否包含已读邮件
     * @param groupId String 邮件组ID
     * @return List<Mail> 获取账户邮件组内邮件
     * */
    List<Mail> getMails(String groupId, boolean includeRead);

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 查询是否包含指定UUID的邮件
     * */
    boolean hasMail(UUID mailId);

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 标记成功
     * 标记邮件已读
     * */
    boolean markAsRead(UUID mailId);

    /**
     * 标记所有邮件已读
     * */
    void markAllAsRead();

    /**
     * @return List<UUID> 领取失败邮件UUID列表
     * 领取所有附件
     * */
    List<UUID> claimAllAttachments();

    /**
     * @param mailId UUID 邮件ID
     * @return boolean 领取成功
     * 领取邮件附件
     * */
    boolean claimAttachments(UUID mailId);

}
