package spring.java.testpring.component;

import org.springframework.stereotype.Component;

import com.org.spring.faces.IShape;

@Component
public class DefaultBeanComponent implements IShape {

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is the default bean ");
	}

}
