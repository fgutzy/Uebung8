import java.awt.*;
import javax.swing.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class TestHelper {

  public static void optionPaneHelper(Runnable r, String... args) {
    try (MockedStatic<JOptionPane> paneMock = Mockito.mockStatic(JOptionPane.class)) {
      var stubbing = paneMock.when(() -> JOptionPane.showInputDialog(Mockito.any()));
      for (int i = 0; i < args.length - 1; i++) {
        stubbing = stubbing.thenReturn(args[i]);
      }

      r.run();

      ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
      ArgumentCaptor<Component> arg2 = ArgumentCaptor.forClass(Component.class);
      paneMock.verify(() -> JOptionPane.showMessageDialog(arg2.capture(), arg.capture()));
      Assertions.assertEquals(args[args.length-1], arg.getValue());
    }
  }
}