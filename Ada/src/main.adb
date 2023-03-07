with Ada.Text_IO;

procedure Main is

   can_stop : boolean := false;
   pragma Atomic(can_stop);

   task type break_thread(time_break : Integer);
   task type main_thread(idd ,step : Long_Long_Integer);


   task body break_thread is
      time_br : Duration := Duration (time_break);
   begin

      delay time_br;
      can_stop := true;
   end break_thread;

   task body main_thread is
      sum : Long_Long_Integer := 0;
      cnt_steps : Long_Long_Integer := 0;
   begin
      loop
         sum := sum + step;
         cnt_steps := cnt_steps + 1;
         exit when can_stop;
      end loop;
      delay 1.0;

      Ada.Text_IO.Put_Line("id: " & idd'Img & " sum: "& sum'Img & " Steps Num: " & cnt_steps'Img & " Step: " & step'Img);
   end main_thread;


   threads_cnt : Integer:= 5;
   step : Long_Long_Integer := 3;
   time_break : Integer := 5;
   b1 : break_thread(time_break);

begin
   declare
   A : Array(1..threads_cnt) of main_thread(1,step);
   begin
      null;
      end;
end Main;
