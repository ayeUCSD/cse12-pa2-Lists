
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here

class EvenNumberChooser implements MyChooser<Integer>{
	@Override
	public boolean chooseElement(Integer input) {
		return input%2 == 0;
	}
}


class BigNumberChooser implements MyChooser<Integer>{

	public boolean chooseElement(Integer input){
		return input >= 100;
	}
}