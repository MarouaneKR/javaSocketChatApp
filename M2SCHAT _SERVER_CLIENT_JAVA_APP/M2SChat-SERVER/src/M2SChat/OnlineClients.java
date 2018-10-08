package M2SChat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class OnlineClients extends Thread {

    @Override
    public void run() {
        DefaultListModel model = new DefaultListModel();
        while (true) {
            System.out.println("0");
            if (!ServerS.conversation.isEmpty()) {
                
                Object ss = ServerMethodes.Interface.Convos.getSelectedValue();
                model.removeAllElements();

                for (int i = 0; i < ServerS.conversation.size(); ++i) {
                    model.addElement(ServerS.conversation.get(i).get(0) + "/" + ServerS.conversation.get(i).get(1));
                    ServerMethodes.Interface.Convos.setModel(model);
                }
                
                ServerMethodes.Interface.Convos.setSelectedValue(ss, true);
                //sleep(5000);

                try {
                    ServerInterface.SBT.waitAndListen();
                } catch (InterruptedException ex) {
                    Logger.getLogger(OnlineClients.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
