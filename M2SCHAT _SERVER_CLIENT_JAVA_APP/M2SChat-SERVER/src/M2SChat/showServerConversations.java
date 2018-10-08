package M2SChat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class showServerConversations extends Thread {

    @Override
    public void run() {
        while (true) {
            if (!ServerInterface.Convos.isSelectionEmpty()) {

                ServerInterface.Conv.setText("");
                for (int i = 0; i < ServerS.conversation.size(); ++i) {
                    if ((ServerS.conversation.get(i).get(0) + "/" + ServerS.conversation.get(i).get(1)).equals(ServerMethodes.Interface.Convos.getSelectedValue())) {
                        for (int j = 2; j < ServerS.conversation.get(i).size(); ++j) {
                            ServerMethodes.Interface.Conv.append(ServerS.conversation.get(i).get(j) + "\n");
                        }
                        break;
                    }
                }
            }
            try {
                ServerInterface.SBT.waitAndListen();
            } catch (InterruptedException ex) {
                Logger.getLogger(showServerConversations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
