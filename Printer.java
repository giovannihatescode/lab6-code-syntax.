import java.util.Queue;
import java.util.LinkedList;

// Represents a document waiting to be printed
class PrintJob {

    private String documentName;
    private int pageCount;

    // Constructor to store document information
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // Returns information about the print job
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName
                + ", Pages: " + pageCount + "]";
    }
}

// Simulates a printer using a queue
public class Printer {

    private Queue<PrintJob> jobQueue;

    // Creates an empty print queue
    public Printer() {
        jobQueue = new LinkedList<>();
    }

    // Adds a new print job to the queue
    public void addJob(PrintJob job) {

        System.out.println("Adding to queue: " + job);

        jobQueue.add(job);
    }

    // Processes the next job in the queue
    public void processNextJob() {

        // Check whether the queue is empty
        if (jobQueue.isEmpty()) {

            System.out.println("The print queue is empty.");

        } else {

            // Remove the first job from the queue
            PrintJob nextJob = jobQueue.remove();

            // Display the job being processed
            System.out.println("Processing: " + nextJob);
        }
    }

    public static void main(String[] args) {

        Printer officePrinter = new Printer();

        // Add three print jobs
        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");

        // Process the first two jobs
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\nNew high-priority job arrives...");

        // Add another job
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        // Process remaining jobs
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        // Check the empty queue
        officePrinter.processNextJob();
    }
}