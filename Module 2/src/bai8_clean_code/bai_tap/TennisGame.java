package bai8_clean_code.bai_tap;

public class TennisGame {

    public static String getScore(String firstNameOfPlayer, String secondNameOfPlayer, int firstScore, int secondScore) {
        String score = "";
        int tempScore=0;
        if (firstScore==secondScore)
        {
            switch (firstScore)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (firstScore>=4 || secondScore>=4)
        {
            int minusResult = firstScore-secondScore;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = firstScore;
                else { score+="-"; tempScore = secondScore;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
