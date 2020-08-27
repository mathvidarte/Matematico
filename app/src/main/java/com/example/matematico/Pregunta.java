package com.example.matematico;

public class Pregunta {
    private String question;
    private int answer;
    public int numeroDePregunta;

    public Pregunta() {
        this.numeroDePregunta = 0;


    }

    public void operacion () {

        this.numeroDePregunta = (int) (Math.random()*19);

        switch (numeroDePregunta){
            case 0:
                question = "2x5";
                answer = 10;
                break;
            case 1:
                question = "5x9";
                answer = 45;
                break;
            case 2:
                question = "20/4";
                answer = 5;
                break;
            case 3:
                question = "50/2";
                answer = 25;
                break;
            case 4:
                question = "6x3";
                answer = 18;
                break;
            case 5:
                question = "2x2";
                answer = 4;
                break;
            case 6:
                question = "8/4";
                answer = 2;
                break;
            case 7:
                question = "4x4";
                answer = 16;
                break;
            case 8:
                question = "3x9";
                answer = 27;
                break;
            case 9:
                question = "9x9";
                answer = 81;
                break;
            case 10:
                question = "7x8";
                answer = 56;
                break;
            case 11:
                question = "23+50";
                answer = 73;
                break;
            case 12:
                question = "150-40";
                answer = 110;
                break;
            case 13:
                question = "90/3";
                answer = 30;
                break;
            case 14:
                question = "20x3";
                answer = 60;
                break;
            case 15:
                question = "15+120";
                answer = 135;
                break;
            case 16:
                question = "200-50";
                answer = 150;
                break;
            case 17:
                question = "90+20";
                answer = 110;
                break;
            case 18:
                question = "150/3";
                answer = 50;
                break;
            case 19:
                question = "1+1";
                answer = 2;
                break;

        }
    }
//GETTERS
    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getNumeroDePregunta() {
        return numeroDePregunta;
    }

    //SETTERS

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setNumeroDePregunta(int numeroDePregunta) {
        this.numeroDePregunta = numeroDePregunta;
    }
}
