package net.miraclemc.miracletools.config.config;

import com.google.inject.Singleton;
import net.elytrium.serializer.annotations.Comment;
import net.elytrium.serializer.annotations.CommentValue;
import net.elytrium.serializer.language.object.YamlSerializable;

@Singleton
public class Config extends YamlSerializable {

    @Comment(
            value = {
                    @CommentValue("Test"),
            },
            at = Comment.At.PREPEND
    )
    public int zalupaPenisHer = 0;
}
