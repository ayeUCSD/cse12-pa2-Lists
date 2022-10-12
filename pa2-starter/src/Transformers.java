
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here

class ModByTwoTransformer implements MyTransformer<Integer>{
	public Integer transformElement(Integer input) {
		return input%2;
	}
}