//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;
import java.io.*;


public class WebTree {
    HTMLLinkNode root;
    HTMLLinkNode cursor,cursorleft,cursorMiddle,cursorRight;
    private int flag=0;
 
    private String rootFileName;    
    private int activeLink;
    private int deadLink;
    private int crosslnk;
    private int totallnk;
   
   public void CreateRootNode()
   {
       root= new HTMLLinkNode();
       cursorleft =cursorMiddle =cursorRight=cursor=root ;
   }
   
   public int getActiveLink() {
        return activeLink;
    }
   
    public int getDeadLink() {
        return deadLink;
    }
    
     public int getCrossLink() {
        return crosslnk;
    }
     
     public int getTotalLink() {
        return totallnk;
    }
     
     public void setTotalLink(String rfilename) {
        rootFileName=rfilename;
    }
      
   private boolean CircularLink(String filename)
   {
        HTMLLinkNode currentcur;
        currentcur=root;        
        String lnkfileName = filename; 
        
        if (lnkfileName.toUpperCase().equals((rootFileName + ".html").toUpperCase()))
        {
           // crosslnk +=1;
            return true;
        }
       
        while (currentcur !=null && currentcur.links != null )
        {         
            if (( currentcur.links[0] != null && currentcur.links[0].getFileName().equals(lnkfileName)) || 
                    ( currentcur.links[1] != null && currentcur.links[1].getFileName().equals(lnkfileName)) ||
                      ( currentcur.links[2] != null && currentcur.links[2].getFileName().equals(lnkfileName))  )
            {
               // crosslnk +=1;
                return true;  
            }          
            currentcur=currentcur.getLeft();
        }
        
        currentcur=root;
        while (currentcur !=null && currentcur.links != null)
        {
             if (( currentcur.links[0] != null && currentcur.links[0].getFileName().equals(lnkfileName)) || 
                    ( currentcur.links[1] != null && currentcur.links[1].getFileName().equals(lnkfileName)) ||
                      ( currentcur.links[2] != null && currentcur.links[2].getFileName().equals(lnkfileName))  )
            {
                //crosslnk +=1;
                return true;  
            }       
            currentcur=currentcur.getMiddle();
        }
        
        currentcur=root;
        while (currentcur !=null && currentcur.links != null)
        {
            if (( currentcur.links[0] != null && currentcur.links[0].getFileName().equals(lnkfileName)) || 
                    ( currentcur.links[1] != null && currentcur.links[1].getFileName().equals(lnkfileName)) ||
                      ( currentcur.links[2] != null && currentcur.links[2].getFileName().equals(lnkfileName))  )
            {
               // crosslnk +=1;
                return true;  
            }       
            currentcur=currentcur.getRight();
        }                
        return false;             
   }
     
    
    public String crawlHTML(String fileName) throws Exception, Exception{
     
        //String Path = "C:\\Users\\ranja\\Documents\\NetBeansProjects\\Programs\\src\\programs\\";
        String relPath = "./" ;
        int htmlIndex = fileName.indexOf(".html");
        //rootFilename = rootFilename.substring(0, htmlIndex);
        relPath += rootFileName + "\\" + fileName;
        //C:\Users\ranja\Documents\NetBeansProjects\Programs\src\programs\cars\cars.html
       
        FileInputStream fis = new FileInputStream(relPath); 
        
        InputStreamReader inStream = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inStream);
        String line = "";
        int counter = 0;
        int startIndex;
        int middleIndex;
        int endIndex;
        String title = "";
        String linkName;
        String fileName2;
        String entireLink;
        HTMLLinkNode link;
        boolean done = false;
        int linkIndex=0;
       // root = new HTMLLinkNode();
       // cursor = root;
        line = reader.readLine();
        while (line != null) 
        {
            if (line.indexOf("<title>") != -1) 
            {
                startIndex = line.indexOf("title");
                startIndex = startIndex + 5;
                endIndex = line.indexOf("</title>");
                title = line.substring(startIndex, endIndex);
                title = title.replace(">", "");
                
            }
            if (line.indexOf("href=") != -1)
            {
                startIndex = line.indexOf("href=");
                startIndex = startIndex + 5;
                endIndex = line.indexOf("</a>");
                entireLink = line.substring(startIndex, endIndex);
                middleIndex = entireLink.indexOf(">");
                fileName2 = entireLink.substring(0, middleIndex); //CARS
                fileName2 = fileName2.replace('"', ' ').trim();
                linkName = entireLink.substring(middleIndex + 1);
                HTMLLinkNode child = new HTMLLinkNode(); 
                boolean clink =false;
                if (cursor !=root) 
                {
                  clink = CircularLink(fileName2);
                }
                totallnk +=1;
                if (clink==true) 
                {
                    crosslnk +=1;
                }
                if (clink==false) 
                {
                     activeLink +=1;
                }
                if ( linkIndex==0) 
                {  
                    child.fileName = fileName2;
                  // child.setPageTitle(title);
                    child.setLinkName(linkName);
                    if (clink==true) child.linkType= LinkType.CIRCULAR;
                            else child.linkType= LinkType.ACTIVE;
                    cursor.addLink(child);
                    //cursor.setLinkName(linkName);
                    cursor.setFileName(fileName);                 
                    cursor.setPageTitle(title);                              
                }
                else if ( linkIndex==1)
                {
                   child.fileName = fileName2;
                   child.setLinkName(linkName);
                   if (clink==true) child.linkType= LinkType.CIRCULAR;
                           else child.linkType= LinkType.ACTIVE;
                   // child.setPageTitle(title);
                    cursor.addLink(child);
                   // cursor.setLinkName(linkName);
                    cursor.setFileName(fileName);
                    cursor.setPageTitle(title);
                                     
                }
               else if ( linkIndex==2) 
               {
                   child.fileName = fileName2;
                   child.setLinkName(linkName);
                   if (clink==true) child.linkType= LinkType.CIRCULAR;
                           else child.linkType= LinkType.ACTIVE;
                  //  child.setPageTitle(title);
                    cursor.addLink(child);
                    //cursor.setLinkName(linkName);
                    cursor.setFileName(fileName);
                   cursor.setPageTitle(title);
                                   
                }
                linkIndex +=1;      
               }
            
               line = reader.readLine();
               if (linkIndex==3 ||  line == null)
               {
                   linkIndex=0;
                   relPath = "./";
                   if (flag==0)
                   {
                      if (cursor.links[0] !=null && (cursor.getLinkAt(0) ==null || cursor.getLinkAt(0).linkType != LinkType.CIRCULAR ))
                      {
                   HTMLLinkNode childleft = new HTMLLinkNode();   
                  // cursorleft=cursor;
                   String fNamel = cursor.getLinkAt(0).getFileName();
                  // cursorleft=cursor;
                   relPath += rootFileName + "\\" + fNamel;
                   File file = new File(relPath);
                    if(file.exists() ) 
                     {   
                         cursorleft.setLeft(childleft);
                         cursorleft =cursor= childleft;                      
                         this.crawlHTML(fNamel);                         
                     }
                      
                    else {cursor.getLinkAt(0).linkType = LinkType.DEAD;cursorleft =cursor;deadLink +=1;totallnk +=1;}
                      }
                    flag +=1;
                   }
                  if (flag==1)
                   {
                    if (cursorMiddle.links[1] !=null && (cursorMiddle.getLinkAt(1) ==null || cursorMiddle.getLinkAt(1).linkType != LinkType.CIRCULAR ))
                      {
                   HTMLLinkNode childmiddle = new HTMLLinkNode();
                   //cursorMiddle=cursor;
                   String fNamem = cursorMiddle.getLinkAt(1).getFileName();
                  
                   relPath += rootFileName + "\\" + fNamem;
                   File file = new File(relPath);
                   if(file.exists()) 
                     {   cursorMiddle.setMiddle(childmiddle);
                         cursorMiddle =cursor= childmiddle;                          
                         this.crawlHTML(fNamem);
                     }
                      
                   else {cursorMiddle.getLinkAt(1).linkType = LinkType.DEAD;cursor =cursorMiddle;deadLink +=1;totallnk +=1;}
                      }
                      
                   flag +=1;
                   }
                   
                  if (flag==2)
                   {
                   if (cursorRight.links[2] !=null  && (cursorRight.getLinkAt(2) ==null || cursorRight.getLinkAt(2).linkType != LinkType.CIRCULAR ))
                      {
                   HTMLLinkNode childright = new HTMLLinkNode();
                  // cursorRight=cursor;
                   String fNamer = cursorRight.getLinkAt(2).getFileName();
                  
                    relPath += rootFileName + "\\" + fNamer;
                    File file = new File(relPath);
                    if(file.exists()) 
                     {
                           cursorRight.setRight(childright);
                           cursorRight =cursor= childright;
                           this.crawlHTML(fNamer);
                     }
                      
                   else{cursorRight.getLinkAt(2).linkType = LinkType.DEAD;cursor =cursorRight;deadLink +=1;totallnk +=1;}
                      }
                   flag +=1;
                   }                   
               }
            }        

          return "SUCCESS";
    }  
   
    public void PrintTree()
    { 
        HTMLLinkNode currentcur;
        currentcur=root;
        String  fileInfo=""; 
        String star = "";
                
        System.out.println(rootFileName + ".html" +  " (" + rootFileName + ")");
        while (currentcur!=null)
        {
           star = "";
           if (currentcur.links[0] !=null)
            {
             if (currentcur.links[0].linkType == LinkType.CIRCULAR) star = "*";
             if (currentcur.links[0].linkType == LinkType.DEAD) star = "***";
            fileInfo = "|- " + currentcur.links[0].getFileName() + star + " (" + currentcur.links[0].getLinkName() + ") [ " + currentcur.links[0].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }                
           
           if (currentcur.links[1]!=null)
            {
             if (currentcur.links[1].linkType == LinkType.CIRCULAR) star = "*";
              if (currentcur.links[1].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[1].getFileName() + star + " (" + currentcur.links[1].getLinkName() + ") [ " + currentcur.links[1].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }
            if (currentcur.links[2]!=null)
            {
                if (currentcur.links[2].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[2].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[2].getFileName()+ star + " (" + currentcur.links[2].getLinkName() + ") [ " + currentcur.links[2].getPageTitle() + " ]"; 
            System.out.println(fileInfo); 
            }
           // }
            currentcur=currentcur.getLeft();
        }
        
           currentcur=root;
        while (currentcur!=null)
        {
            star = "";
            if (currentcur != root) 
            {
           if (currentcur.links[0] !=null)
            {
                if (currentcur.links[0].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[0].linkType == LinkType.DEAD) star = "***";
            fileInfo = "|- " + currentcur.links[0].getFileName() + star + " (" + currentcur.links[0].getLinkName() + ") [ " + currentcur.links[0].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }                
           
           if (currentcur.links[1]!=null)
            {
                if (currentcur.links[1].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[1].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[1].getFileName() + star + " (" + currentcur.links[1].getLinkName() + ") [ " + currentcur.links[1].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }
            if (currentcur.links[2]!=null)
            {
                if (currentcur.links[2].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[2].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[2].getFileName()+ star + " (" + currentcur.links[2].getLinkName() + ") [ " + currentcur.links[2].getPageTitle() + " ]"; 
            System.out.println(fileInfo); 
            }
            }
            currentcur=currentcur.getMiddle();            
        }
        
          currentcur=root;
        while (currentcur!=null)
        {
            star = "";
           if (currentcur != root) 
            {
          if (currentcur.links[0] !=null)
            {
                if (currentcur.links[0].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[0].linkType == LinkType.DEAD) star = "***";
            fileInfo = "|- " + currentcur.links[0].getFileName() + star + " (" + currentcur.links[0].getLinkName() + ") [ " + currentcur.links[0].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }                
           
           if (currentcur.links[1]!=null)
            {
                if (currentcur.links[1].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[1].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[1].getFileName() + star + " (" + currentcur.links[1].getLinkName() + ") [ " + currentcur.links[1].getPageTitle() + " ]"; 
            System.out.println(fileInfo);
            }
            if (currentcur.links[2]!=null)
            {
                if (currentcur.links[2].linkType == LinkType.CIRCULAR) star = "*";
                 if (currentcur.links[2].linkType == LinkType.DEAD) star = "***";
             fileInfo = "|- " + currentcur.links[2].getFileName()+ star + " (" + currentcur.links[2].getLinkName() + ") [ " + currentcur.links[2].getPageTitle() + " ]"; 
            System.out.println(fileInfo); 
            }
            }
            currentcur=currentcur.getRight();            
        }
        
    }
}
           