/**
 * The contents of the three export files we receive.
 * (Kept in memory so the demo runs without any files on disk.)
 */
public class SampleData {

    // Exported from Blackboard: comma-separated, first line is a header.
    public static final String BLACKBOARD_CSV =
            "studentId,course,score\n"
            + "202312340,SWE316,88\n"
            + "202298761,SWE316,74\n"
            + "202311111,SWE316,105\n";      // invalid: score above 100

    // Dumped from the LMS API: one JSON object per line inside [ ... ].
    public static final String LMS_JSON =
            "[\n"
            + "{\"studentId\":\"202312340\",\"course\":\"ICS202\",\"score\":91},\n"
            + "{\"studentId\":\"20231234\",\"course\":\"ICS202\",\"score\":80},\n"   // invalid: 8-digit ID
            + "{\"studentId\":\"202298761\",\"course\":\"ICS202\",\"score\":67}\n"
            + "]\n";

    // From the old Banner system: fixed-width columns
    // [0-9) student ID, [9-16) course (padded), [16-19) score (padded).
    public static final String BANNER_FIXED_WIDTH =
            "202312340MATH201 95\n"
            + "202255555MATH201 70\n"         // invalid: student not enrolled in MATH201
            + "202298761MATH201101\n";        // invalid: score above 100
}
