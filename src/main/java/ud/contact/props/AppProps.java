package ud.contact.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix="app1")
public class AppProps {
	
	private Map<String,String> messages = new HashMap<String,String>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
}
