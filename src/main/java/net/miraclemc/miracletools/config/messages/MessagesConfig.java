package net.miraclemc.miracletools.config.messages;

import com.google.inject.Singleton;
import net.elytrium.serializer.annotations.Comment;
import net.elytrium.serializer.annotations.CommentValue;
import net.elytrium.serializer.language.object.YamlSerializable;

@Singleton
public class MessagesConfig extends YamlSerializable {

    @Comment(
            value = {
                    @CommentValue(" MiracleTools - Your miracle tools"),
            },
            at = Comment.At.PREPEND
    )

    public MessagesConfigList messages = new MessagesConfigList();
}
