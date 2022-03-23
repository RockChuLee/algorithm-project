package com.nyu.oa.twitter;


import java.util.Arrays;

/**
 * Sam is part of the organizing team arranging the university's career fair and hes list of companies and
 * their respective arrival times and durations. Due to university-wide budget cuts thris only one
 * stagel(dais avaiable on the entre campus so only one event can occur at a tm . Given each company s
 * arival time and the duratonthy aill tay deemine the maximumnumber of promotional events that can be
 * hosted during the career fair.
 * <p>
 * Forexample,the are n=5companies thatillanive at times arial=[1,3.3,5.7/an ill ty for duration=[2.2,1,2.1
 * The frt compan arivs at time 1 and staysfor 2 hours.Attime 3, two companies arive butonl 1 a styforether 1
 * or 2hours.Thenet companies arve at tmes 5 and7 and do not conlit wth each oter h total therecan be
 * a maximum of4 promotional events.
 * <p>
 * Function Description
 * Complete the function maxEvents in the editor below.t must return an integer that represents the maximum
 * number of promotional events that can be hosted.
 * maxEvents has the following parameter(s):
 * arrival[arrival[0]...arrival[n-1]: an array of integers where ith element is the arrival time of
 * the i company.
 * duration[duration[...duration[n-1]: an array of integers where ith element is the duration that
 * thei company's stay at the career fair.
 */

//https://leetcode.com/discuss/interview-question/374846/
public class UniversityCareerFair {
    public static int num_maxEvents(int[] arr, int[] dur) {
        int drop = 0;
        int NumOfEvents = arr.length;
        int[][] intervals = new int[NumOfEvents][2];

        for (int i = 0; i < NumOfEvents; i++) {
            intervals[i] = new int[]{arr[i], arr[i] + dur[i]};
        }

        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        // the finish time of first event;
        int curTime = intervals[0][1];

        for (int i = 1; i < NumOfEvents; i++) {
            int[] toSchedual = intervals[i];
            if (toSchedual[0] < curTime)
                drop++;
            else {
                curTime = toSchedual[1];
            }
        }
        return NumOfEvents - drop;


    }

    public static void main(String[] args) {
        int[] arrival1 = {1, 3, 3, 5, 7};
        int[] duration1 = {2, 2, 1, 2, 1};
        System.out.println(num_maxEvents(arrival1, duration1));
        int[] arrival2 = {1, 3, 3, 5, 7, 6, 9};
        int[] duration2 = {2, 2, 1, 2, 1, 10, 2};
        System.out.println(num_maxEvents(arrival2, duration2));
        int[] arrival = {1, 3, 35, 7};
        int[] duration = {2, 2, 1, 2, 1};
        System.out.println(num_maxEvents(arrival, duration));
    }
}
