package JobReadyConsumer;

import java.util.List;

public class Producer implements Runnable{

    List<Integer> questionList = null;
    final int LIMIT =5;
    private int questionNO;

    public Producer(List<Integer> questionList){
        this.questionList = questionList;
    }

    public void produceQuestion(int questionNO) throws InterruptedException {
        synchronized(questionList) {
            while (questionList.size() == LIMIT) {
                System.out.println("Question have piled up...wait for answers");
                questionList.wait();

            }
        }
        synchronized (questionList){
            System.out.println("New Question: " + questionNO);
            questionList.add(questionNO);
            Thread.sleep(100);
            questionList.notify();
        }

    }
    @Override
    public void run() {
        for(int i=0; i<50; i++) {
            try {
                produceQuestion(questionNO++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
