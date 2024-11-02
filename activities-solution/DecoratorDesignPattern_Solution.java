public interface MessageSender {
  public void sendMessage(String message);
}

public class EmailMessageSender implements MessageSender{
  private String recipient;

  public EmailMessageSender(String recipient) {
    this.recipient = recipient;
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("Sending message to " + recipient + ": " + message);
  }
}

public abstract class AbstractMessageDecorator implements MessageSender {
  private MessageSender sender;

  public AbstractMessageDecorator(MessageSender sender) {
    this.sender = sender;
  }

  @Override
  public void sendMessage(String message) {
    /* 
     * this abstract decorator only does the basic thing that a decorator does: forwarding requests 
     * to send a message to the object that it's "decorating"/wrapping
    */
    sender.sendMessage(message);
  }
}

public class EncryptedMessageDecorator extends AbstractMessageDecorator {
    public EncryptedMessageDecorator(MessageSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String message) {
        message = encryptMessage(message);
        // after adding its special touch "the decoration", the default implementation is called
        super.sendMessage(message);
    }

    private String encryptMessage(String message) {
        // Simple mock encryption (for demonstration)
        return new StringBuilder(message).reverse().toString();
    }
}

public class CompressedMessageDecorator extends AbstractMessageDecorator {
    public CompressedMessageDecorator(MessageSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String message) {
        message = compressMessage(message);
        super.sendMessage(message);
    }

    private String compressMessage(String message) {
        // Mock compression by removing spaces
        return message.replaceAll("\\s+", "");
    }
}

public class SignedMessageDecorator extends AbstractMessageDecorator {
    public SignedMessageDecorator(MessageSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(String message) {
        message = addSignature(message);
        super.sendMessage(message);
    }

    private String addSignature(String message) {
        return message + "\n-- Signature";
    }
}

public class App {
    public static void main(String[] args) {
        // Base message sending with core component
        MessageSender sender = new EmailMessageSender("favor.composition.over.inheritance@swe316.com");
        
        // Decorate with signature
        MessageSender signedSender = new SignedMessageDecorator(sender);
        
        // Decorate with encryption and compression
        MessageSender encryptedCompressedSender = new CompressedMessageDecorator(
                                                         new EncryptedMessageDecorator(
                                                             signedSender));
                                                             
        // Send message with all decorations applied
        encryptedCompressedSender.sendMessage("Hello, World!");
    }
} 
