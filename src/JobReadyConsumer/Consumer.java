package JobReadyConsumer;

import java.util.List;

public class Consumer implements Runnable {
    List<Integer> questionList = null;

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answeringQuestion() throws InterruptedException {


        synchronized(questionList) {
            while (questionList.isEmpty()) {
                System.out.println("No question to answer: waiting for producer to produce more Questions ");
                questionList.wait();
            }
        }
        synchronized (questionList){
            Thread.sleep(5000);
            System.out.println("Answered Question: " + questionList.remove(0));
            Thread.sleep(100);
            questionList.notify();
        }

    }


    @Override
    public void run() {
        for(int i=0; i<50; i++){
            try {
                answeringQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
