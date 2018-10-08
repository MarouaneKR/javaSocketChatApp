package M2SChat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class showConversation extends Thread {

    private StartBlockThread SBT;

    public showConversation(StartBlockThread SBT) {
        this.SBT = SBT;
    }

    @Override
    public void run() {

        while (true) {

            if (!ClientMethodes.Interface.online.isSelectionEmpty()) {

                ClientMethodes.Interface.Conversation.setText("");
                for (int i = 0; i < ClientMethodes.Conversations.size(); ++i) {
                    if (ClientMethodes.Conversations.get(i).get(0).equals(ClientMethodes.Interface.online.getSelectedValue())) {
                        for (int j = 1; j < ClientMethodes.Conversations.get(i).size(); ++j) {
                            ClientMethodes.Interface.Conversation.append(ClientMethodes.Conversations.get(i).get(j) + "\n");
                        }

                    }
                }

            }
           
            try {
                this.SBT.waitAndListen();
            } catch (InterruptedException ex) {
                Logger.getLogger(showConversation.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(showConversation.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }

    }

}
