# Decision-Engine ⚙️⚖️
A decision engine using Spring Boot, Drools, and data tables, allowing non-technical users to update business logic directly via Excel sheets, eliminating the need for engineering involvement in rule changes.
The decision engine is designed for an online learning platform to give response according to the video and test progress.


## Decision Table ##

![yq0u0ueg](https://github.com/user-attachments/assets/31b6ca31-179d-4b46-bbce-3ca5cd5fb055)

## Sample Input and Their Output ##

**Input**
```
{
    "user_id": 1,
    "current_test": "CCQ",//CCQ or BT
    "current_ch_count": 4,
    "ch_th": 6, //chapter threshhold
    "media_count": 1, //current media count (3 limit)
    "remaining_count": 10, //remaining video in chapter
    "skip_count": 0, //skip videos
    "current_media_status": "sc",
    "current_test_score": 65
}
```
**Output**
```
{
    "user_id": 1,
    "videoProgress": 0,
    "pdfProgress": 0,
    "package_id": 0,
    "exam_id": 0,
    "current_test": "CCQ",
    "current_ch_count": 5,
    "ch_th": 6,
    "media_count": 2,
    "remaining_count": 9,
    "skip_count": 0,
    "current_media_status": "UC",
    "current_test_score": 65,
    "response": "Next Video"
}
```
## Generated Rules ##
```
//generated from Decision Table
import com.trial.models.progressModel;
import com.trial.models.UserModel;
global Boolean dusker;
// rule values at A12, header at A7
rule "A1"
	salience 65535
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(videoProgress==40, package_id==1, exam_id==2)
	then
		userObject.response="Test V1";
		userObject.current_media_status="SC";
end

// rule values at A13, header at A7
rule "A2"
	salience 65534
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(videoProgress==50, package_id==1, exam_id==2)
	then
		userObject.response="Test V2";
		userObject.current_media_status="SC";
end

// rule values at A14, header at A7
rule "A3"
	salience 65533
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(videoProgress==60, package_id==1, exam_id==2)
	then
		userObject.response="Test V3";
		userObject.current_media_status="SC";
end

// rule values at A21, header at A16
rule "P1"
	salience 65532
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(pdfProgress==40, package_id==1, exam_id==2)
	then
		userObject.response="Test P1";
		userObject.current_media_status="SC";
end

// rule values at A22, header at A16
rule "P2"
	salience 65531
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(pdfProgress==50, package_id==1, exam_id==2)
	then
		userObject.response="Test P2";
		userObject.current_media_status="SC";
end

// rule values at A23, header at A16
rule "P3"
	salience 65530
	activation-group "PROGRESS"
	ruleflow-group "PROGRESS"
	when
		userObject: UserModel(pdfProgress==60, package_id==1, exam_id==2)
	then
		userObject.response="Test P3";
		userObject.current_media_status="SC";
end

// rule values at A31, header at A26
rule "U1"
	salience 65529
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score<=60, skip_count==0)
	then
		userObject.skip_count=1;
		userObject.response="Skip Video";
		userObject.current_media_status=null;
end

// rule values at A32, header at A26
rule "U2"
	salience 65528
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score<=60, skip_count==1)
	then
		userObject.skip_count=2;
		userObject.response="Skip Topic";
		userObject.current_media_status=null;
end

// rule values at A33, header at A26
rule "U3"
	salience 65527
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score<=60, skip_count==2)
	then
		userObject.skip_count=0;
		userObject.response="New Subject-Chapter";
		userObject.current_media_status=null;
		userObject.current_ch_count=0;
end

// rule values at A41, header at A36
rule "U4"
	salience 65526
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="CCQ", current_ch_count < ch_th, media_count==3)
	then
		userObject.response="Big Test";
		userObject.media_count=0;
end

// rule values at A42, header at A36
rule "U5"
	salience 65525
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="CCQ", current_ch_count == ch_th)
	then
		userObject.response="Big Test";
		userObject.media_count=0;
end

// rule values at A43, header at A36
rule "U6"
	salience 65524
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="CCQ", remaining_count==0)
	then
		userObject.response="Big Test";
		userObject.media_count=0;
end

// rule values at A44, header at A36
rule "U7"
	salience 65523
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="CCQ", current_ch_count < ch_th)
	then
		userObject.current_media_status="UC";
		userObject.response="Next Video";
		userObject.media_count=userObject.getMedia_count()+1;
		userObject.current_ch_count=userObject.current_ch_count+1;
		userObject.remaining_count=userObject.remaining_count-1;
end

// rule values at A45, header at A36
rule "B1"
	salience 65522
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="BT", current_ch_count < ch_th, media_count==3)
	then
		userObject.current_media_status="UC";
		userObject.response="Next Video";
		userObject.media_count=0;
		userObject.current_ch_count=userObject.current_ch_count+1;
		userObject.remaining_count=userObject.remaining_count-1;
end

// rule values at A46, header at A36
rule "B2"
	salience 65521
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="BT", current_ch_count < ch_th, remaining_count==0)
	then
		userObject.current_media_status="UC";
		userObject.response="Next Chapter";
		userObject.media_count=0;
		userObject.current_ch_count=0;
end

// rule values at A47, header at A36
rule "B3"
	salience 65520
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="BT", current_ch_count == ch_th)
	then
		userObject.current_media_status="UC";
		userObject.response="Next Subject-Chapter";
		userObject.media_count=0;
		userObject.current_ch_count=0;
end

// rule values at A48, header at A36
rule "B4"
	salience 65519
	activation-group "USERPROGRESS"
	ruleflow-group "USERPROGRESS"
	when
		userObject: UserModel(current_test_score>60, current_test=="BT", current_ch_count < ch_th)
	then
		userObject.current_media_status="UC";
		userObject.response="Next Video";
		userObject.media_count=userObject.getMedia_count()+1;
		userObject.current_ch_count=userObject.current_ch_count+1;
		userObject.remaining_count=userObject.remaining_count-1;
end
```

