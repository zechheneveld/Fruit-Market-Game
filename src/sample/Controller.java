package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {

    @FXML
    public Button btnBuyApple;
    @FXML
    public Button btnBuyOrange;
    @FXML
    public Button btnBuyBanana;
    @FXML
    public Button btnBuyGrape;

    @FXML
    public Button btnSellApple;
    @FXML
    public Button btnSellOrange;
    @FXML
    public Button btnSellBanana;
    @FXML
    public Button btnSellGrape;

    @FXML
    public Text priceApple;
    @FXML
    public Text priceOrange;
    @FXML
    public Text priceBanana;
    @FXML
    public Text priceGrape;

    @FXML
    public Text boxApple;
    @FXML
    public Text boxOrange;
    @FXML
    public Text boxBanana;
    @FXML
    public Text boxGrape;

    @FXML
    public Text boxSellApple;
    @FXML
    public Text boxSellOrange;
    @FXML
    public Text boxSellBanana;
    @FXML
    public Text boxSellGrape;

    @FXML
    public Text cashOwned;


    @FXML
    public Text timer;

    int high = 10;
    int low = 1;

    Random diceRoll = new Random();
    int randomApple = diceRoll.nextInt(high);
    int randomOrange = diceRoll.nextInt(high);
    int randomBanana = diceRoll.nextInt(high);
    int randomGrape = diceRoll.nextInt(high);

    private int counterBuyApple = 0;
    private int counterBuyOrange = 0;
    private int counterBuyBanana = 0;
    private int counterBuyGrape = 0;

    private int counterSellApple = 0;
    private int counterSellOrange = 0;
    private int counterSellBanana = 0;
    private int counterSellGrape = 0;


    public int countTimer = 16;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    updateBoxes();
    setUpClock();


    }

    public void  updateBoxes(){
       // int totalCash = counterBuyApple + counterSellApple + counterSellGrape + counterBuyGrape + counterSellBanana + counterSellBanana + counterSellOrange + counterBuyOrange


        int orCashSell = randomOrange * counterSellOrange;
        int apCashSell = randomApple * counterSellApple;
        int grCashSell = randomGrape * counterSellGrape;
        int baCashSell = randomBanana * counterSellBanana;

        int orCashBuy = randomOrange * counterBuyOrange;
        int apCashBuy = randomApple * counterBuyApple;
        int baCashBuy = randomBanana * counterBuyBanana;
        int grCashBuy = randomGrape * counterBuyGrape;

        int totalCash = 100 - (orCashBuy + orCashSell + apCashBuy + apCashSell + grCashBuy + grCashSell + baCashBuy + baCashSell + grCashBuy + grCashSell);

        boxApple.setText("Apples Owned: " + (counterBuyApple + counterSellApple));
        boxOrange.setText("Oranges Owned: " + (counterBuyOrange + counterSellOrange));
        boxBanana.setText("Bananas Owned: " + (counterBuyBanana + counterSellBanana));
        boxGrape.setText("Grapes Owned: " + (counterBuyGrape + counterSellGrape));

        priceApple.setText("Price: $" + randomApple);
        priceOrange.setText("Price: $" + randomOrange);
        priceBanana.setText("Price: $" + randomBanana);
        priceGrape.setText("Price: $" + randomGrape);
        cashOwned.setText("Cash Available: $" + totalCash);

    }

    public void clickBuyApple(ActionEvent actionEvent){

        counterBuyApple++;
        updateBoxes();


    }
    public void clickBuyOrange(ActionEvent actionEvent){

        counterBuyOrange++;
        updateBoxes();


    }
    public void clickBuyBanana(ActionEvent actionEvent){

        counterBuyBanana++;
        updateBoxes();


    }
    public void clickBuyGrape(ActionEvent actionEvent){

        counterBuyGrape++;
        updateBoxes();


    }
    public void clickSellApple(ActionEvent actionEvent){
//        totalOwnedApple = counterBuyApple + counterSellApple;
//        if (totalOwnedApple < 2){
//            btnSellApple.setDisable(true);
//            updateBoxes();
//        } else if (totalOwnedApple > 0){
//            btnSellApple.setDisable(false);
//            updateBoxes();
//        }
        counterSellApple--;
        updateBoxes();


    }
    public void clickSellOrange(ActionEvent actionEvent){
        counterSellOrange--;

        updateBoxes();


    }   public void clickSellBanana(ActionEvent actionEvent){
        counterSellBanana--;

        updateBoxes();


    }
    public void clickSellGrape(ActionEvent actionEvent){
        counterSellGrape--;

        updateBoxes();



    }
    public void setUpClock(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countTimer--;

                String stringTimer = String.valueOf(countTimer);
                timer.setText(stringTimer);
                if (countTimer == 0){
                    countTimer = 16;
                    randomApple = diceRoll.nextInt(high);
                    randomOrange = diceRoll.nextInt(high);
                    randomBanana = diceRoll.nextInt(high);
                    randomGrape = diceRoll.nextInt(high);
                    updateBoxes();
                }

            }
        };

        Timer timey = new Timer();

        timey.schedule(task,1000L,1000L);
    }

}
