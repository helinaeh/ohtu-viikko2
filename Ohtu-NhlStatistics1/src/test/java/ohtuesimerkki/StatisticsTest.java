package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.Reader;

public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    
//        @Override
//        public int read(char[] cbuf, int off, int len) throws IOException {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//        @Override
//        public void close() throws IOException {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchLoytaaHaetunPelaajanJosListalla1() {
        assertEquals(new Player("Kurri", "EDM", 37, 53).toString(), stats.search("Kurri").toString());
    }
    
    @Test
    public void searchLoytaaHaetunPelaajanJosListalla2() {
        assertEquals(new Player("Yzerman", "DET", 42, 56).toString(), stats.search("Yzerman").toString());
    }
    
    @Test
    public void searchEiLoydaPelaajaaJosEiListalla() {
        assertEquals(null, stats.search("Mimmi"));
    }
    
    @Test
    public void teamPalauttaaTiiminPelaajat1() {
        ArrayList<Player> pelaajat = new ArrayList<Player>();
        pelaajat.add(new Player("Semenko", "EDM", 4, 12));
        pelaajat.add(new Player("Kurri", "EDM", 37, 53));
        pelaajat.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(pelaajat.toString(), stats.team("EDM").toString());
    }
    
    @Test
    public void teamPalauttaaTiiminPelaajat2() {
        ArrayList<Player> pelaajat = new ArrayList<Player>();
        pelaajat.add(new Player("Lemieux", "PIT", 45, 54));
        assertEquals(pelaajat.toString(), stats.team("PIT").toString());
    }
    
    @Test
    public void teamPalauttaaTyhjanListanJosTiimiaEiLoydy1() {
        assertEquals(new ArrayList<Player>(), stats.team("KUR"));
    }
    
    @Test
    public void teamPalauttaaTyhjanListanJosTiimiaEiLoydy2() {
        assertEquals(new ArrayList<Player>(), stats.team("TSU"));
    }
    
    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        assertEquals(3, stats.topScorers(3).size());
    }
    
    @Test
    public void topScorersPalauttaaOikeatPelaajat() {
        ArrayList<Player> topPelaajat = new ArrayList<Player>();
        topPelaajat.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(topPelaajat.toString(), stats.topScorers(1).toString());
    }
    
    @Test
    public void topScorersPalauttaaTyhjanListanJosParamNolla() {
        assertEquals(new ArrayList<Player>(), stats.topScorers(0));
    }
    
//    @Test
//    public void hello() {
//        assertEquals(0, 0);
//    }
//    
//    @Test
//    public void hello() {
//        assertEquals(0, 0);
//    }
//    
//    @Test
//    public void hello() {
//        assertEquals(0, 0);
//    }
//    
//    @Test
//    public void hello() {
//        assertEquals(0, 0);
//    }
}

    

