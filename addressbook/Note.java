/**
 * Class: Note
 */
package addressbook;

/**
 * Note is the class for creating an object for note content.
 * It accept all the characters; but,
 * it has max limit.
 * Everything exceeds the max limit will be omitted.
 * 
 * @author mingmin
 *
 */
public class Note {
  
  /** The content of a note */
  private String noteContent;
  
  /** The max limit for a note content */
  private final static int maxSize = Integer.MAX_VALUE;
  
  /**
   * Instantiates note class
   *  
   * @param note
   */
  public Note(String note) {
    this.noteContent = rangeCheck(note);
  }
  
  /**
   * Check the format for note.
   * If valid, means under the max limit.
   * 
   * @param note
   * @return
   */
  private String rangeCheck(String note){
    
    // Check for null
    if (note == null || note.length() == 0){
      return "";
    }
    // Check for max limit
    else if (note.length() > maxSize) {
      return note.substring(0, maxSize - 1);
    }
    else {
      return note;
    }
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return noteContent;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((noteContent == null) ? 0 : noteContent.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Note))
      return false;
    Note other = (Note) obj;
    if (noteContent == null) {
      if (other.noteContent != null)
        return false;
    } else if (!noteContent.equals(other.noteContent))
      return false;
    return true;
  }

  /**
   * Get the note content
   * 
   * @return the noteContent
   */
  public String getNoteContent() {
    return noteContent;
  }

  /**
   * Set the note content after checking
   * it's format 
   * 
   * @param noteContent the noteContent to set
   */
  public void setNoteContent(String noteContent) {
    this.noteContent = rangeCheck(noteContent);
  }
  
  

}