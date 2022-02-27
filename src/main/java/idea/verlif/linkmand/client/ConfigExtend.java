package idea.verlif.linkmand.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import idea.verlif.socket.core.client.ClientConfig;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author Verlif
 */
@JsonIgnoreProperties({"receiveHandler", "connectedListener", "closedListener"})
public class ConfigExtend extends ClientConfig implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigExtend name(String name) {
        this.name = name;
        return this;
    }

    public static ConfigExtend load() throws IOException {
        File file = new File("config.json");
        ObjectMapper mapper = new ObjectMapper();
        if (file.exists()) {
            ConfigExtend extend = mapper.readValue(file, ConfigExtend.class);
            if (extend.getName() == null || extend.getName().length() == 0) {
                throw new IOException("Please edit " + file.getName() + ", and write the name.");
            }
            return extend;
        } else {
            ConfigExtend extend = new ConfigExtend();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(file, extend);
            return extend;
        }
    }
}
