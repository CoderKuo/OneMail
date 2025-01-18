package base;

import com.dakuo.onemail.api.account.Account;
import com.dakuo.onemail.api.mail.Mail;
import com.dakuo.onemail.interal.OneMailManager;
import com.dakuo.onemail.interal.common.AttachmentService;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 大阔
 * @since 2025/1/17 21:51
 */
public class MailTest {

    private static final UUID sender = UUID.randomUUID();

    // 模拟使用逻辑
    public void start(){
        OneMailManager.registerAttachService(new ItemAttachmentService());

        Account systemAccount = OneMailManager.getService().getSystemAccount();
        Account sender = OneMailManager.getService().getAccount(MailTest.sender);

        List<Object> attachments = new ArrayList<>();
        attachments.add(new ItemStack(Material.ACACIA_DOOR));

        Mail mail = new Mail("test mail", "example", new ArrayList<String>() {{
            add("test content");
        }}, attachments, 0);


        systemAccount.sendMail(sender,mail);

    }


}


class ItemAttachmentService implements AttachmentService<ItemStack> {

    @Override
    public String getName() {
        return "Item";
    }

    @Override
    public String displayName(ItemStack attachment) {
        ItemStack itemStack = attachment;
        if (itemStack == null) {
            return "空";
        }
        ItemMeta itemMeta = itemStack.getItemMeta() == null ? Bukkit.getItemFactory().getItemMeta(itemStack.getType()) : itemStack.getItemMeta();
        if (itemMeta == null) {
            return "空";
        }
        return "物品["+itemMeta.getDisplayName()+"] * "+itemStack.getAmount();
    }


    @Override
    public org.bukkit.inventory.ItemStack displayIcon(ItemStack attachment) {
        return attachment;
    }

    @Override
    public boolean claim(Account account, Object attachment) {
        UUID id = account.getId();
        Player player = Bukkit.getPlayer(id);
        player.getInventory().addItem((ItemStack) attachment);
        return true;
    }
}
