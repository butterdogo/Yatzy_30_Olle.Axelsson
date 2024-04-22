import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException
     {

         int dicetotal = 0;                          //Summan av tärningana man rullat
         int score = 30;                             //den score man börjar med
         int diceloop = 1;                           //en inte för att aktivera loopen som rullat tärningar
         int[] dicesave = new int[6];                //Skapar en array för där de sparade tärningarna ska ligga
         int dicesavedplace = 0;                     //en int för det plats som tärningen ska sparas



        Scanner roundstart = new Scanner(System.in);                                            //En scanner som kollar vad man skriver in i kommandorutan
        String start;                                                                           //En string som ska jämföras med  roundstart för att starta spelet
        System.out.println("Press start");
        start = roundstart.nextLine();                                                          //stringen jämförs med input från tangentbord
        if (start == start) {System.out.println("Yatzy 30 early beta 10% fungerande spel");}    //Om man spriver någonting så startar spelet
        Thread.sleep(1 * 200);                                                            //vänta i 0,2 sekunder


        Scanner playertotalinput = new Scanner(System.in);                                      //En scanner som ska blir hur många spelare man vill ha
        Scanner playeradd = new Scanner(System.in);                                             //En scanner för namnet på en spelare
        System.out.println("Hur många spelare?");
        int totalplayers = playertotalinput.nextInt();                                          //Det antalet spelare man vill ha blir en int = totalplayers
        String[] players = new String[totalplayers];                                            //en string players blir lika långa som antalet spelare




        if (totalplayers > 1) {                                                                 //om man är mer än en spelare ska loopen starta
            for (int i = 0; i < totalplayers; i++) {
                System.out.println("Spelare " +( i + 1));
                players[i] = playeradd.next();

                                                                                                     // Hela är en loop för att välja namn och lägga till namnen i en Array samt printa ut dem
                String[] Playerslist = Arrays.copyOfRange(players, 0, totalplayers);
                String playernameStr = Arrays.toString(players);
                System.out.println(playernameStr);
            }
        }





        for(int dicelength = 6;dicelength>0;) {                                                      // en loop som startar om man har tärningar kvar att rulla
            int[] dice = new int[dicelength];                                                        //en array för det tärningar som rullas

            while (diceloop == 1) {                                                                  //en loop som akiveras diceloop är = 1 vilket gör att man kan välja när det sak köra



                for (int i = 0;i < dicelength;) {                                                    //En loop som kör om det finns tärningar kvar att rulla

                    dice[i] = dice();                                                                // tärningar läggs in varför sig i den rad dom ska vara

                    i++;
                }
                System.out.print("Rullade: ");
                for (int element : dice) {

                    System.out.print(element + ", ");                                                    // en forloop som ska skriva ut alla tärningar
                    dicetotal = dicetotal + element;

                }


                diceloop = 2;
            }

            while (diceloop == 2) {
                System.out.println("Vilken tärningsplats vill du spara?");
                Scanner dicesaveinput = new Scanner(System.in);                                         //en scanner för den tärningen som ska sparas
                int dicesaveplace = Integer.parseInt(dicesaveinput.nextLine()) - 1;                     //tärningen kan skriver in...

                dicesave[dicesavedplace] = dice[dicesaveplace];                                         //... sparas i en array på rätt plats.
                dicelength--;                                                                           //ta bort en plats från array:en
                dicesavedplace++;                                                                       //byter till nesta plats i array:en
                System.out.println("Sparade tärningar: ");
                for (int element : dicesave) {
                    System.out.print(element + ", ");                                                   //en loop som skriver ut den array:en som tärningarna sparas i

                }

                diceloop = 0;

                Scanner ifloopchoice = new Scanner(System.in);
                int endphase = 0;
                if (dicelength > 0) {
                    System.out.println("Om du vill spara en till tryck 0 annars tryck annan siffra");
                    int ifloop;
                    ifloop = Integer.parseInt(ifloopchoice.nextLine());
                    if (ifloop == 0) {
                        diceloop = 2;                                                                                 //en loop som känner av om det finns kvar tärningar för att antingel loopa om eller avsluta
                    } else {
                        diceloop = 1;
                    }
                } else {
                    endphase = 1;
                }

                if (endphase == 1) {
                    int dicesum = dicesave[0] + dicesave[1] + dicesave[2] + dicesave[3] + dicesave[4] + dicesave[5];        //tärningarna skrivs ut i följd
                    int newscore = 30;                                                                                      //den nya scoren man ska få börjar på 30 så att man kan subtrahera
                    if (dicesum < 30) {                                                                                     //en if sats som tar pårt score om man slår totalt mindre än 30 på sina tärningar
                        int scoreminus = 30 - dicesum;
                        newscore = newscore - 30;
                        newscore = 30 - scoreminus;
                    }

                    System.out.println("your roll" + dicesum);
                    Thread.sleep(1 * 500);
                    System.out.println("New score: " + newscore);
                    Thread.sleep(1 * 500);
                    System.out.println("END");
                }
            }
        }
    }
    public static int dice(){                                                           //En metod som slumpar fram en siffra mellan 1 och 6 och ger den namnet dice som sedan returnar
        int dice = 1;

        dice = dice * (int)(Math.random() * 6);
        dice = dice + 1;
        return dice;

    }



}







