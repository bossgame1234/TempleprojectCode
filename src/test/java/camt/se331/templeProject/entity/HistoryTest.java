package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.HistoryDao;
import camt.se331.templeProject.service.HistoryService;
import camt.se331.templeProject.service.HistoryServiceImpl;
import camt.se331.templeProject.service.PictureUtil;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
/**
 * Created by SONY on 8/5/2558.
 */
public class HistoryTest {
    @Before
    public void setUpHistory(){
    }
    @Test
    public void testGetHistory(){
        History history = new History("This is temple",PictureUtil.getPicture("picture/temple2.jpg"));
        history.setHistoryID(1L);
        HistoryDao historyDao = mock(HistoryDao.class);
        HistoryService historyService = new HistoryServiceImpl(historyDao);
        when(historyDao.getHistory()).thenReturn(history);
        assertThat(historyService.getHistory(), is(history));
        assertThat(historyService.getHistory().getHistoryDes(),is("This is temple"));
        assertThat(historyService.getHistory().getHistoryID(), is(1L));
        //เหลือ test picture location
    }

    @Test
    public void testUpdateHistory(){
        History history = new History("This is temple",PictureUtil.getPicture("picture/temple2.jpg"));
        history.setHistoryID(1L);
        HistoryDao historyDao = mock(HistoryDao.class);
        HistoryService historyService = new HistoryServiceImpl(historyDao);
        history.setHistoryDes("22");
        when(historyDao.updateHistory(history)).thenReturn(history);
        assertThat(historyService.updateHistory(history).getHistoryDes(),is("22"));



    }
}
