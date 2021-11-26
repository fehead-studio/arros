package cn.arros.server.log;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

/**
 * 自定义Appender,将日志输出到WebSocket
 * @Author Verge
 * @Date 2021/11/21 16:25
 * @Version 1.0
 */
@Plugin(name = "WebSocketAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class WebSocketAppender extends AbstractAppender {

    private final LoggerQueue loggerQueue  = LoggerQueue.getInstance();

    protected WebSocketAppender(String name,
                                Filter filter,
                                Layout<? extends Serializable> layout,
                                boolean ignoreExceptions,
                                Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }

    // TODO：未考虑并发
    @Override
    public void append(LogEvent event) {
        loggerQueue.push(new String(getLayout().toByteArray(event)));
    }

    @PluginFactory
    public static WebSocketAppender createAppender(@PluginAttribute("name") String name,
                                                   @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
                                                   @PluginElement("Layout") Layout layout,
                                                   @PluginElement("Filters") Filter filter) {
        if (name == null) {
            LOGGER.error("No name provided for WebSocketAppender");
            return null;
        }

        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new WebSocketAppender(name, filter, layout, ignoreExceptions, Property.EMPTY_ARRAY);
    }
}
