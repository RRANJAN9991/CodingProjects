//Rahul Ranjan ID# - 111448179
package programs;

public class HTMLLinkNode {
    
    HTMLLinkNode left, right, middle;
    String fileName, pageTitle, linkName;
    LinkType linkType;
    HTMLLinkNode[] links = new HTMLLinkNode[3];
   
    public HTMLLinkNode() {
        left = null;
        middle = null;
        right = null;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
    public String getPageTitle() {
        return pageTitle;
    }
    
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    
    public String getLinkName() {
        return linkName;
    }
    
    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }
    
    public LinkType getLinkType() {
        return linkType;
    }
    
    public HTMLLinkNode[] getLinks() {
        return links;
    }
    
    public boolean isDeadLink() {
        return this.getLinkType() == LinkType.DEAD;
    }
    
    public boolean isCircularLink() {
        return this.getLinkType() == LinkType.CIRCULAR;
    }
    
    public HTMLLinkNode getLeft() {
        return left;
    } 
    
    public void setLeft(HTMLLinkNode newLeft) {
        left = newLeft;
    }
    
    public HTMLLinkNode getRight() {
        return right;
    }
    
    public void setRight(HTMLLinkNode newRight) {
        right = newRight;
    }
    
     public HTMLLinkNode getMiddle() {
        return middle;
    }
    
    public void setMiddle(HTMLLinkNode newMiddle) {
        middle = newMiddle;
    }
    public void addLink(HTMLLinkNode newLink) throws Exception, Exception {
        if (newLink != null) {
            for (int i = 0; i < this.links.length; i++) {
                if(links[i] == null) {
                    links[i] = newLink;
                    break;
                }
                else {
                    if (i + 1 == links.length) {
                        throw new Exception("Full Node");
                    }
                    continue;
                }
            }
        }
        else {
            throw new Exception("Illegal arguement");
        }
    }
    
    public HTMLLinkNode getLinkAt(int index) throws Exception {
        HTMLLinkNode linkGot;
        if (index >= 0 && index < this.links.length) {
            if (links[index] != null) {
                linkGot = links[index];
            }
            else {
                linkGot = null;
            }
        }
        else {
            throw new Exception("Index out of bounds. ");
        }
        return linkGot;
    }
    
  /*  public boolean equals(HTMLLinkNode object) {
        return (this.getFileName() == object.getFileName() && this.getPageTitle() == object.getPageTitle());
    }
   */ 
    public String toString() {
        String fileInfo = "";
        if (this.getLinkType() == LinkType.CIRCULAR) {
            fileInfo = "|- " + fileName + "* (" + linkName + ") [ " + pageTitle + " ]"; 
        }
        else if (this.getLinkType() == LinkType.DEAD) {
            fileInfo = "|- " + fileName + " (" + linkName + ") [ *** ]";
        }
        return fileInfo; 
    }
}
    
