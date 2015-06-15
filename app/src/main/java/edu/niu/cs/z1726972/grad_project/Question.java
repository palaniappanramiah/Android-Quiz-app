/******************************************************************
 * Name           : Palaniappan Ramiah
 * ZID            : Z1726972
 * Class          : Android
 * Assignment No. : Graduate Project
 * Program Name   : Question.java
 * Description    : Class to store all the questions
 * Due Date       : 04/30/2015 11:59:59 pm
 *****************************************************************/
package edu.niu.cs.z1726972.grad_project;

public class Question {

    private int questionId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;

    public Question()
    {
        questionId = 0;
        question = "";
        optionA = "";
        optionB = "";
        optionC = "";
        optionD = "";
        answer = "";
    }

    public Question(String ques, String optA, String optB, String optC,
                    String optD, String ans) {
        question = ques;
        optionA = optA;
        optionB = optB;
        optionC = optC;
        optionD = optD;
        answer = ans;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}