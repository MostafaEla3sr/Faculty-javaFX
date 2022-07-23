package com.example.project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
public class HelloController {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("data.fxml"));
    FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("insertdata.fxml"));
    FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("updatedata.fxml"));
    FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("deletedata.fxml"));
    FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("entergrades.fxml"));
    FXMLLoader fxmlLoader5 = new FXMLLoader(HelloApplication.class.getResource("showdata.fxml"));
    Connection con ;
    PreparedStatement stat;
    Stage stage;
    Scene scene;
    @FXML
    private Label emailupdatelab;
    @FXML
    private TextField emailupdatetxt;
    @FXML
    private Label fnameupdatelab;
    @FXML
    private TextField fnameupdatetxt;
    @FXML
    private TextField idupdatetxt;
    @FXML
    private Label levelupdatelab;
    @FXML
    private TextField levelupdatetxt;
    @FXML
    private Label lnameupdatelab;
    @FXML
    private TextField lnameupdatetxt;
    @FXML
    private Label phoneupdatelab;
    @FXML
    private TextField phoneupdatetxt;
    @FXML
    private Button showdatabtn;
    @FXML
    private Button updatebtn;
    @FXML
    private TextField passsignintxt;
    @FXML
    private TextField userphonetxt;
    @FXML
    private TextField userlnametxt;
    @FXML
    private TextField userleveltxt;
    @FXML
    private TextField useridtxt;
    @FXML
    private TextField userfnametxt;
    @FXML
    private TextField useremailtxt;
    @FXML
    private TextField usersignintxt;
    @FXML
    private Label hlsignin;
    @FXML
    private Button deletebtn;
    @FXML
    private Button deleteshowdatabtn;
    @FXML
    private Label emaildeletelab;
    @FXML
    private TextField emaildeletetxt;
    @FXML
    private Label fnamedeletelab;
    @FXML
    private TextField fnamedeletetxt;
    @FXML
    private TextField iddeletetxt;
    @FXML
    private Label leveldeletelab;
    @FXML
    private TextField leveldeletetxt;
    @FXML
    private Label lnamedeletelab;
    @FXML
    private TextField lnamedeletetxt;
    @FXML
    private Label phonedeletelab;
    @FXML
    private TextField phonedeletetxt;
    @FXML
    private Label gpahl;
    @FXML
    private Label numhl;
    @FXML
    private TextField sub1txt;
    @FXML
    private TextField sub2txt;
    @FXML
    private TextField sub3txt;
    @FXML
    private TextField sub4txt;
    @FXML
    private TextField sub5txt;
    @FXML
    private TextField sub6txt;
    @FXML
    private TextField subidtxt;
    @FXML
    private Label deg_lab;
    @FXML
    private TextField deg_txt;
    @FXML
    private Label fname_lab;
    @FXML
    private TextField fname_txt;
    @FXML
    private Label id_lab;
    @FXML
    private TextField id_txt;
    @FXML
    private Label lev_lab;
    @FXML
    private TextField lev_txt;
    @FXML
    private Label lname_lab;
    @FXML
    private TextField lname_txt;
    //Constrructor
    //Done
    public HelloController() {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty" , "root" , "");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    //Done
    void signinaction(ActionEvent event) throws Exception {

        String txt1 = usersignintxt.getText();
        String txt2 = passsignintxt.getText();
        PreparedStatement s = con.prepareStatement("select * from register where username=? and password=?");
        s.setString(1,txt1);
        s.setString(2,txt2);
        ResultSet r = s.executeQuery();
        if (r.next())
        {
            scene = new Scene(fxmlLoader.load());
            stage  = new Stage();
            stage.setScene(scene);
            stage.setTitle("Data");
            stage.show();

        }
        else
        {
            hlsignin.setText("Incorrect email or password");
        }
    }
    //Done
    @FXML
    void userinsertaction(ActionEvent event) throws Exception {

        stat = con.prepareStatement("insert into students values(?,?,?,?,?,?)");
        stat.setString(1,useridtxt.getText());
        stat.setString(2,userfnametxt.getText());
        stat.setString(3,userlnametxt.getText());
        stat.setString(4,userphonetxt.getText());
        stat.setString(5,useremailtxt.getText());
        stat.setString(6,userleveltxt.getText());
        stat.executeUpdate();
        useridtxt.setText("");
        userfnametxt.setText("");
        userlnametxt.setText("");
        userphonetxt.setText("");
        useremailtxt.setText("");
        userleveltxt.setText("");
    }
    //Done
    @FXML
    void deleteaction(ActionEvent event)throws Exception {
        scene = new Scene(fxmlLoader3.load());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Delete");
        stage.show();
    }
    //Done
    @FXML
    void entergradesaction(ActionEvent event) throws Exception{
        scene = new Scene(fxmlLoader4.load());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Enter grades");
        stage.show();
    }
    //DONE
    @FXML
    void insertaction(ActionEvent event)throws Exception {
        scene = new Scene(fxmlLoader1.load());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Inertion");
        stage.show();
    }
    //Done
    @FXML
    void showdataaction(ActionEvent event) throws Exception{
        scene = new Scene(fxmlLoader5.load());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Data");
        stage.show();
    }
    //Done
    @FXML
    void updateaction(ActionEvent event) throws Exception{

        scene = new Scene(fxmlLoader2.load());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Update");
        stage.show();

    }
    //Done
    @FXML
    void showdatainupdateaction(ActionEvent event)throws Exception {
            stat = con.prepareStatement("select * from students where student_ID=" + idupdatetxt.getText());
            ResultSet r = stat.executeQuery();
                while (r.next())
                {
                    fnameupdatetxt.setText(r.getString(2));
                    lnameupdatetxt.setText(r.getString(3));
                    phoneupdatetxt.setText(r.getString(4));
                    emailupdatetxt.setText(r.getString(5));
                    levelupdatetxt.setText(r.getString(6));
                }
        fnameupdatelab.setVisible(true);
        fnameupdatetxt.setVisible(true);
        lnameupdatelab.setVisible(true);
        lnameupdatetxt.setVisible(true);
        emailupdatelab.setVisible(true);
        emailupdatetxt.setVisible(true);
        phoneupdatelab.setVisible(true);
        phoneupdatetxt.setVisible(true);
        levelupdatelab.setVisible(true);
        levelupdatetxt.setVisible(true);
        updatebtn.setVisible(true);
        showdatabtn.setVisible(false);
        idupdatetxt.setEditable(false);

    }
    //Done
    @FXML
    void userupdateaction(ActionEvent event)throws Exception {

        stat = con.prepareStatement("update students set fname  =?, lname =?, phone =?,  email =?, level =? where student_ID="+idupdatetxt.getText());
        stat.setString(1,fnameupdatetxt.getText());
        stat.setString(2,lnameupdatetxt.getText());
        stat.setString(3,phoneupdatetxt.getText());
        stat.setString(4,emailupdatetxt.getText());
        stat.setString(5,levelupdatetxt.getText());
        stat.executeUpdate();
        idupdatetxt.setText("");
        fnameupdatetxt.setText("");
        lnameupdatetxt.setText("");
        phoneupdatetxt.setText("");
        emailupdatetxt.setText("");

        levelupdatetxt.setText("");

        fnameupdatelab.setVisible(false);
        fnameupdatetxt.setVisible(false);
        lnameupdatelab.setVisible(false);
        lnameupdatetxt.setVisible(false);
        emailupdatelab.setVisible(false);
        emailupdatetxt.setVisible(false);
        phoneupdatelab.setVisible(false);
        phoneupdatetxt.setVisible(false);

        levelupdatelab.setVisible(false);
        levelupdatetxt.setVisible(false);
        updatebtn.setVisible(false);
        showdatabtn.setVisible(true);
        idupdatetxt.setEditable(true);


    }
    //Done
    @FXML
    void showdataindeleteaction(ActionEvent event)throws Exception {
        stat = con.prepareStatement("select * from students where student_ID=" + iddeletetxt.getText());
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            fnamedeletetxt.setText(r.getString(2));
            lnamedeletetxt.setText(r.getString(3));
            phonedeletetxt.setText(r.getString(4));
            emaildeletetxt.setText(r.getString(5));
            leveldeletetxt.setText(r.getString(6));
        }
        fnamedeletelab.setVisible(true);
        fnamedeletetxt.setVisible(true);
        lnamedeletelab.setVisible(true);
        lnamedeletetxt.setVisible(true);
        emaildeletelab.setVisible(true);
        emaildeletetxt.setVisible(true);
        phonedeletelab.setVisible(true);
        phonedeletetxt.setVisible(true);
        leveldeletelab.setVisible(true);
        leveldeletetxt.setVisible(true);
        deletebtn.setVisible(true);
        deleteshowdatabtn.setVisible(false);
    }
    //Done
    @FXML
    void userdeleteaction(ActionEvent event) throws Exception{

        stat = con.prepareStatement("delete from students  where student_ID="+iddeletetxt.getText());
        stat.executeUpdate();
        iddeletetxt.setText("");
        fnamedeletetxt.setText("");
        lnamedeletetxt.setText("");
        phonedeletetxt.setText("");
        emaildeletetxt.setText("");
        leveldeletetxt.setText("");
        fnamedeletelab.setVisible(false);
        fnamedeletetxt.setVisible(false);
        lnamedeletelab.setVisible(false);
        lnamedeletetxt.setVisible(false);
        emaildeletelab.setVisible(false);
        emaildeletetxt.setVisible(false);
        phonedeletelab.setVisible(false);
        phonedeletetxt.setVisible(false);
        leveldeletelab.setVisible(false);
        leveldeletetxt.setVisible(false);
        deletebtn.setVisible(false);
        deleteshowdatabtn.setVisible(true);

    }
    //Done
    @FXML
    void enterdegrees(ActionEvent event) throws Exception{
    int [] grades = new int[6];
    double gpa , sum = 0.0;
    grades[0]=Integer.parseInt(sub1txt.getText());
    grades[1]=Integer.parseInt(sub2txt.getText());
    grades[2]=Integer.parseInt(sub3txt.getText());
    grades[3]=Integer.parseInt(sub4txt.getText());
    grades[4]=Integer.parseInt(sub5txt.getText());
    grades[5]=Integer.parseInt(sub6txt.getText());
    for (int i = 0 ; i<6 ; i++)
    {
        if (grades[i]>=90)
            sum+=(4.0*3);
        else if(grades[i]>=85)
            sum+=(3.7*3);
        else if(grades[i]>=80)
            sum+=(3.3*3);
        else if(grades[i]>=75)
            sum+=(3.0*3);
        else if(grades[i]>=70)
            sum+=(2.7*3);
        else if(grades[i]>=65)
            sum+=(2.4*3);
        else if(grades[i]>=60)
            sum+=(2.2*3);
        else if(grades[i]>=50)
            sum+=(2.0*3);
        else
            sum+=(0*3);

    }
    gpa = (sum/18.0);
if (gpa>=2.5)
    numhl.setText("6");
else
    numhl.setText("3");

    gpahl.setText(String.valueOf(gpa));
        stat = con.prepareStatement("insert into grades values(?,?,?,?,?,?,?,?)");
        stat.setString(1,subidtxt.getText());
        stat.setString(2,sub1txt.getText());
        stat.setString(3,sub2txt.getText());
        stat.setString(4,sub3txt.getText());
        stat.setString(5,sub4txt.getText());
        stat.setString(6,sub5txt.getText());
        stat.setString(7,sub6txt.getText());
        stat.setString(8,gpahl.getText());
        stat.executeUpdate();
        gpahl.setVisible(true);
        numhl.setVisible(true);
        subidtxt.setText("");
        sub1txt.setText("");
        sub2txt.setText("");
        sub3txt.setText("");
        sub4txt.setText("");
        sub5txt.setText("");
        sub6txt.setText("");
    }
    //Done
    @FXML
    void gpaaction(ActionEvent event) throws Exception{

        stat = con.prepareStatement("SELECT  g.student_ID , g.GPA , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by GPA ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
    //Done
    @FXML
    void sub1action(ActionEvent event) throws Exception {
            stat = con.prepareStatement("SELECT  g.student_ID , g.sub_1_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_1_grade ASC");
            ResultSet r = stat.executeQuery();
            while (r.next())
            {
                id_txt.setText(r.getString(1));
                deg_txt.setText(r.getString(2));
                fname_txt.setText(r.getString(3));
                lname_txt.setText(r.getString(4));
                lev_txt.setText(r.getString(5));
            }
                        lname_txt.setVisible(true);
                        lev_txt.setVisible(true);
                        id_txt.setVisible(true);
                        deg_txt.setVisible(true);
                        fname_txt.setVisible(true);
                        lname_lab.setVisible(true);
                        fname_lab.setVisible(true);
                        lev_lab.setVisible(true);
                        deg_lab.setVisible(true);
                        id_lab.setVisible(true);
    }
    //Done
    @FXML
    void sub2action(ActionEvent event) throws Exception{

        stat = con.prepareStatement("SELECT  g.student_ID , g.sub_2_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_2_grade ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
    //Done
    @FXML
    void sub3action(ActionEvent event)throws Exception {
        stat = con.prepareStatement("SELECT  g.student_ID , g.sub_3_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_3_grade ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
    //Done
    @FXML
    void sub4action(ActionEvent event) throws Exception{

        stat = con.prepareStatement("SELECT  g.student_ID , g.sub_4_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_4_grade ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
    //Done
    @FXML
    void sub5action(ActionEvent event) throws Exception {

        stat = con.prepareStatement("SELECT  g.student_ID , g.sub_5_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_5_grade ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
    //Done
    @FXML
    void sub6action(ActionEvent event) throws Exception{

        stat = con.prepareStatement("SELECT  g.student_ID , g.sub_6_grade , s.fname , s.lname , s.level FROM grades g JOIN students s ON (g.student_ID = s.student_ID) ORDER by sub_6_grade ASC");
        ResultSet r = stat.executeQuery();
        while (r.next())
        {
            id_txt.setText(r.getString(1));
            deg_txt.setText(r.getString(2));
            fname_txt.setText(r.getString(3));
            lname_txt.setText(r.getString(4));
            lev_txt.setText(r.getString(5));
        }
        lname_txt.setVisible(true);
        lev_txt.setVisible(true);
        id_txt.setVisible(true);
        deg_txt.setVisible(true);
        fname_txt.setVisible(true);
        lname_lab.setVisible(true);
        fname_lab.setVisible(true);
        lev_lab.setVisible(true);
        deg_lab.setVisible(true);
        id_lab.setVisible(true);

    }
}