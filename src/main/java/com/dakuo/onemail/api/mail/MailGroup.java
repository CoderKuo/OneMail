package com.dakuo.onemail.api.mail;

import java.util.List;
import java.util.UUID;

/**
 * @author Index
 * */
public interface MailGroup {

    /**
     * @return String 获取邮件组ID
     * */
    String getGroupId();

    /**
     * @return String 获取邮件组Name
     * */
    String getName();

    /**
     * @return UUID 获取邮件组所属账户UUID
     * */
    UUID getOwner();

    /**
     * @return List<Mail> 获取邮件组内邮件列表
     * */
    List<Mail> getMails();

    /**
     * @param mail 添加邮件
     * */
    void addMail(Mail mail);

    /**
     * @param mailUID 删除邮件
     * */
    void removeMail(UUID mailUID);
}
