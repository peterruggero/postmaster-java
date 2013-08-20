package io.postmaster;

import static org.junit.Assert.assertNotNull;
import io.postmaster.entity.Box;
import io.postmaster.entity.Item;
import io.postmaster.entity.PackageFitQueryMessage;
import io.postmaster.entity.result.BoxCreationResult;
import io.postmaster.entity.result.FetchBoxResult;
import io.postmaster.entity.result.PackageFitResult;
import io.postmaster.errors.HTTPError;

import java.util.Date;

import org.junit.Test;

public class BoxTests extends PostMasterTest {

    
    @Test
    public void testCreateBox() throws HTTPError {
        Box box = Box.create()
                .setWidth(10)
                .setHeight(12)
                .setLength(8)
                .setName("My box "+new Date().getTime());
        
        BoxCreationResult result =  box.createBox();
        assertNotNull(result.getCreatedPackageId());
    }
    
    
    @Test
    public void testFetchBoxes() throws HTTPError {
        FetchBoxResult result = Box.fetch(null, null);
        assertNotNull(result.getResults());
    }
    
    @Test
    public void testFit() throws HTTPError {
        
        PackageFitQueryMessage fitMessage = PackageFitQueryMessage.create()
                .addBox(Box.create()
                        .setWidth(6)
                        .setLength(6)
                        .setHeight(6)
                        .setSku("123ABC"))
                        
                .addBox(Box.create()
                        .setWidth(6)
                        .setLength(6)
                        .setHeight(6)
                        .setSku("123ABCD"))
                
                .addItem(new Item().setWidth(2.2).setLength(3).setHeight(1).setCount(2));
        
        PackageFitResult result = Box.fit(fitMessage);
        
        assertNotNull(result.getFitInfo());
                
    }
    
}
