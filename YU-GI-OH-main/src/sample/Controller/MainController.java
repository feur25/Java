package sample.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

import javafx.scene.input.MouseEvent;
import sample.View.MonsterCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {
    public Button SelectedDeckOne;
    public ImageView EmplacementOne;
    private MonsterCard HandCardPlayerOne;
    private MonsterCard HandCardPlayerTwo;
    private int LifeBarPlayerOne;
    private int LifeBarPlayerTwo;
    private int points, GuardPoints, AttackPointsCardOne, AttackPointsCardTwo, PositionCard;
    private ArrayList<MonsterCard> graveyardOnePlayer = new ArrayList<>();
    private ArrayList<MonsterCard> graveyardSecondPlayer = new ArrayList<>();
    private ArrayList<MonsterCard> FirstDeck = new ArrayList<>();
    private ArrayList<MonsterCard> SecondDeck = new ArrayList<>();

    private int Counter1 = 0;
    private int Counter2 = 0;
    private String name, information, element, numberCard;
    private List<String> type = null;
    private int level, attack, defense;
    public int turn = 0, countTurn = 0;
    public boolean startFirstPlayer = false;

    public MainController() throws FileNotFoundException {
    }

    public enum elements{
        Vent,
        Terre,
        Eau,
        Feu,
        Lumière,
        Ténèbre,
        Divin

    };

    public int cardDisplayInGroundPlayerOne = 0, cardDisplayInGroundPlayerTwo = 0, countClickedCard = 0;

    @FXML
    private ImageView FirstMap;

    @FXML
    private ImageView SecondMap;

    @FXML
    private ImageView SecondCart;

    @FXML
    private ImageView FirstCart;

    @FXML
    private Button SelectCardSecondPlayer;

    @FXML
    private Button SelectCardFirstPlayer;

    @FXML
    private Label LifeSpanSecondPlayer;

    @FXML
    private Label LifeSpanFirstPlayer;

    @FXML
    private Button Fight;

    @FXML
    private Button Start; 

    @FXML
    private Button Position2;

    @FXML
    private Button Position1;
    @FXML
    private Button FirstCard;



    @FXML
    void Start(ActionEvent event) {
        start();
    }
    void reset(){
        LifeBarPlayerOne = 8000;
        LifeBarPlayerTwo = 8000;
        LifeSpanFirstPlayer.setText(""+LifeBarPlayerOne);
        LifeSpanSecondPlayer.setText(""+LifeBarPlayerTwo);
        Collections.shuffle(FirstDeck);
        Collections.shuffle(SecondDeck);
    }
    void SelectPlayerStart(){
        int random;
        random = (int)(Math.random() * 2);
        if(random == 1){
            startFirstPlayer = true;
        }
        System.out.println(random);
    }
    void start(){
        reset();
        SelectPlayerStart();
        CreateCardToDisplay();
        SelectdCardFirstPlayer();
        SelectedCardSecondPlayer();
    }
    @FXML
    void setDeckOne(){
        MonsterCard monsterCard;
        ArrayList<MonsterCard> CardFirstPlayer = new ArrayList<>();
        Image Card1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("../icons/1.png")));
        monsterCard = new MonsterCard(
                "Invocateur Dragon Bleu", 4, 1500, 600,
                "Si cette carte est envoyée depuis le Terrain au Cimetière : vous pouvez ajouter 1 Monstre Normal dragon, Guerrier ou Magicien depuis votre Deck a votre main.",
                "Magicien", String.valueOf(elements.Vent), "YS14-FR017",false,  Card1);
        FirstDeck.add(monsterCard);
        SecondDeck.add(monsterCard);

        Image Card2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("../icons/corridoreTop.jpg")));
        monsterCard = new MonsterCard("Corridore Top", 4, 1100, 800, "","", element, numberCard,false, Card2);
        FirstDeck.add(monsterCard);
        SecondDeck.add(monsterCard);
    }

    void CreateCardToDisplay(){
        setDeckOne();
    }
    @FXML
    void FirstCard (javafx.scene.input.MouseEvent event) {
        if(Objects.equals(SecondCart.imageProperty().getName(), EmplacementOne.imageProperty().getName())) {
            if (startFirstPlayer && !FirstDeck.get(cardDisplayInGroundPlayerOne).getOneTap()) {
                countClickedCard++;
                HandCardPlayerOne.setOneTap(false);
                System.out.println("tu peut taper");
            } else {
                switch (countClickedCard) {
                    case 1:
                        countClickedCard = 0;
                        SecondPlayerAttack();
                        HandCardPlayerOne.setOneTap(true);
                        break;
                    case 0:
                        System.out.println("Merdouille");
                        break;
                    default:
                        System.out.println("le nombre est  szz: " + countClickedCard);
                }
            }
        }else{
            System.out.println(SecondCart.imageProperty().getName() +  " " + EmplacementOne.imageProperty().getName());
        }
    }
    public void SecondCard(MouseEvent mouseEvent) {
        if(startFirstPlayer){
            switch(countClickedCard) {
                case  1:
                    countClickedCard = 0;
                    HandCardPlayerTwo.setOneTap(true);
                    FirstPlayerAttack();
                    break;
                case  0:
                    System.out.println("étrange");
                    break;
                default:
                    System.out.println("le nombre est : " + countClickedCard);
            }
        }else if(!SecondDeck.get(cardDisplayInGroundPlayerOne).getOneTap()){
            countClickedCard++;
            HandCardPlayerTwo.setOneTap(false);
            System.out.println("J2 va taper ATTENTION !!");
        }else{
            System.out.println("tu as déja taper ce tour la !! kasos");
        }
    }


    @FXML
    void SelectCardFirstPlayer(ActionEvent event) {
        SelectdCardFirstPlayer();
    }


    void SelectdCardFirstPlayer(){
        if(Counter1 < FirstDeck.size()){
            HandCardPlayerOne = FirstDeck.get(Counter1);

            String s = HandCardPlayerOne.getName();

            int l = HandCardPlayerOne.getLevel();
            int a = HandCardPlayerOne.getAttack();
            int d = HandCardPlayerOne.getDefence();
            boolean t = HandCardPlayerOne.getOneTap();
            Image ix = HandCardPlayerOne.getImage();
            HandCardPlayerOne.setPosition(0);
            //FirstCart.setImage(ix);
            //FirstCart.setRotate(180);
            Counter1 ++;
        }else{
            Counter1 = 0;
        }
    }

    @FXML
    void SelectCardSecondPlayer(ActionEvent event){
        SelectedCardSecondPlayer();
    }

    void SelectedCardSecondPlayer(){
        if(Counter2 < SecondDeck.size()){
            HandCardPlayerTwo = SecondDeck.get(Counter2);

            String s = HandCardPlayerTwo.getName();

            int l = HandCardPlayerTwo.getLevel();
            int a = HandCardPlayerTwo.getAttack();
            int d = HandCardPlayerTwo.getDefence();
            boolean t = HandCardPlayerTwo.getOneTap();
            Image ix = HandCardPlayerTwo.getImage();
            HandCardPlayerTwo.setPosition(0);
            EmplacementOne.setImage(ix);
            Counter2++;
        }else{
            Counter2 = 0;
        }
    }
    void gameCount(){
        countTurn++;
        if(countTurn == 2){
            countTurn = 0;
            ++turn;
        }
        System.out.println("le tour est : " + turn);
    }

    @FXML
    void Lotta(ActionEvent event) {
        System.out.println(startFirstPlayer);
        if(startFirstPlayer) {
            FirstPlayerAttack();
        }else{
            SecondPlayerAttack();
        }
    }
    @FXML
    void TurnEnd(ActionEvent event){
        startFirstPlayer = !startFirstPlayer;
        gameCount();
    }


    /*MonsterCard set1(String nameCard, int levelCard, int attackCard, int defenseCard, String infoCard, Image imageCard){
        MonsterCard NewInstanceMonsterCard = new MonsterCard(nameCard,levelCard,attackCard,defenseCard, infoCard, imageCard);
        return NewInstanceMonsterCard;
    }*/


    @FXML
    void setPositionG1(ActionEvent event) {
        PositionCard = HandCardPlayerOne.getPosition();
        if(PositionCard == 0){
            HandCardPlayerOne.setPosition(1);
            FirstCart.setRotate(90);
        }
        else if(PositionCard == 1){
            HandCardPlayerOne.setPosition(0);
            FirstCart.setRotate(180);
        }
    }

    @FXML
    void setPositionG2(ActionEvent event) {
        PositionCard = HandCardPlayerTwo.getPosition();
        if(PositionCard == 0){
            HandCardPlayerTwo.setPosition(1);
            SecondCart.setRotate(-90);
        }
        else if(PositionCard == 1){
            HandCardPlayerTwo.setPosition(0);
            SecondCart.setRotate(0);
        }
    }
    void isDead(){
        if((LifeBarPlayerOne <= 0) || (LifeBarPlayerTwo <= 0)){
            start();
        }
    }
    void PosAttack(){
        PositionCard = HandCardPlayerTwo.getPosition();
        if(PositionCard == 0){
            AttackPointsCardTwo = HandCardPlayerTwo.getAttack();
            if(AttackPointsCardOne > AttackPointsCardTwo){
                points = AttackPointsCardOne-AttackPointsCardTwo;
                LifeBarPlayerTwo = LifeBarPlayerTwo - points;
                LifeSpanSecondPlayer.setText(""+LifeBarPlayerTwo);
                graveyardSecondPlayer.add(HandCardPlayerTwo);
                //carte détruit salope et retire les pv de la salope de dégat qui resste
                SelectdCardFirstPlayer();
            }else if (AttackPointsCardOne == AttackPointsCardTwo){
                SelectdCardFirstPlayer();
                SelectedCardSecondPlayer();
            }else {
                points = AttackPointsCardTwo-AttackPointsCardOne;
                LifeBarPlayerOne = LifeBarPlayerOne - points;
                LifeSpanFirstPlayer.setText(""+LifeBarPlayerOne);
                graveyardOnePlayer.add(HandCardPlayerOne);
                SelectedCardSecondPlayer();
            }
        }
        else if(PositionCard == 1){
            AttackPointsCardOne = HandCardPlayerOne.getAttack();
            GuardPoints = HandCardPlayerTwo.getDefence();

            if(AttackPointsCardOne >= GuardPoints){
                points = AttackPointsCardOne-GuardPoints;
                LifeBarPlayerTwo = LifeBarPlayerTwo - points;
                LifeSpanSecondPlayer.setText(""+LifeBarPlayerTwo);
                graveyardSecondPlayer.add(HandCardPlayerTwo);
                SelectedCardSecondPlayer();
            } else if (AttackPointsCardOne == AttackPointsCardTwo){
                SelectdCardFirstPlayer();
                SelectedCardSecondPlayer();
            } else {
                points = GuardPoints-AttackPointsCardOne;
                LifeBarPlayerOne = LifeBarPlayerOne - points;
                LifeSpanFirstPlayer.setText(""+LifeBarPlayerOne);
                graveyardOnePlayer.add(HandCardPlayerOne);
                SelectdCardFirstPlayer();
            }
        }
        isDead();
    }
    void SecondPlayerAttack(){
        PosAttack();
    }
    void FirstPlayerAttack(){
        PosAttack();
    }
}


