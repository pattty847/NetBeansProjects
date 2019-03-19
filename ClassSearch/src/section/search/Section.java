package section.search;

public class Section {
    
    // String variables set to hold each criteria for a Section
    private String subject, days, time, course, section, CRN, credits;
    
    // Null constructor for Section Object
    Section(){
    }

    // Returns the Section's subject
    public String getSubject() {
        return subject;
    }

    // Setter for Section's subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Returns the Section's days
    public String getDays() {
        return days;
    }

    // Setter for the Section's days
    public void setDays(String days) {
        this.days = days;
    }

    // Returns the Section's time period
    public String getTime() {
        return time;
    }

    // Setter for the Section's time period
    public void setTime(String time) {
        this.time = time;
    }

    // Returns the Section's course
    public String getCourse() {
        return course;
    }

    // Setter for the Section's course
    public void setCourse(String course) {
        this.course = course;
    }

    // Returns the Section's section number (string)
    public String getSection() {
        return section;
    }

    // Setter for the Section's section number
    public void setSection(String section) {
        this.section = section;
    }

    // Returns the CRN
    public String getCRN() {
        return CRN;
    }

    // Setter for the Section CRN
    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    // Returns the Sections credits count
    public String getCredits() {
        return credits;
    }

    // Setter for the Sections credits count
    public void setCredits(String credits) {
        this.credits = credits;
    }
    
    // To string method which concats all the objects information into a console message
    @Override
    public String toString() {
        return "Section{" + "subject=" + subject + ", days=" + days + ", course=" + course + ", section=" + section + ", CRN=" + CRN + ", credits=" + credits + ", time=" + time + '}';
    }
}
