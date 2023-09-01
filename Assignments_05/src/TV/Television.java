package TV;

public class Television {
    private int channelcount;
    private int currentChannel;

    public Television(int channels) {
        this.channelcount = channels;
        this.currentChannel = 1;
    }

    public void ChangeChannel() {
        currentChannel++;
        if(currentChannel > channelcount) {
            currentChannel = 1;
        }
    }

    public void Watch() {
        System.out.printf("Watching channel %d\n", currentChannel);
    }
}
