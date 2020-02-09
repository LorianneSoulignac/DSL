# DSL FSM - User Manual
This dsl allows to specifiate a program which change state of something.

##Step1:
User must specifiate all states (initial, final, and others)
He must write this specification in gemoc editor according to a syntax
Example : FSM [name] {
  state [state1],[state2]
  Transition [nameTr] [state1] -> [state2]
}

##Step2:
When user have finished his specification , he save the file when he clicks on "Ctrl +s" 
several files are generated:
- FSM.java : it's the main class 
- StateAbtr.java : it's an abstract class whitch it create state without type
- State.jave : it's class witch inherits of SateAbstr class
- Transition.java : it's a class witch build a transition 

##Step3:
In the console terminal user must compile all java class generated thanks to "javac" command.
Then, user must launch the FSM.class thanks to "java" command. 

