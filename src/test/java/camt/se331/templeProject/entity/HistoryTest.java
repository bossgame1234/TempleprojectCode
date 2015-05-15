package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.DbHistoryDao;
import camt.se331.templeProject.dao.HistoryDao;
import camt.se331.templeProject.service.HistoryService;
import camt.se331.templeProject.service.HistoryServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static junitparams.JUnitParamsRunner.$;
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
    public void testHistoryEntity(){
        History history = new History();
        history.setHistoryDes("this is temple history");
        assertThat(history.getHistoryDes(), is("this is temple history"));
        history.setHistoryDes(null);
        assertThat(history.getHistoryDes(), is(isNull()));

    }
    @Test
    public void testUpdateHistory(){
        History history = new History();
        history.setHistoryDes("this is temple history");
        HistoryDao historyDao = mock(HistoryDao.class);
        when(historyDao.updateHistory(history)).thenReturn(history);


        HistoryService historyService = new HistoryServiceImpl();
        assertThat(historyService.updateHistory(history).getHistoryDes(),is("this is temple history"));



    }
}
