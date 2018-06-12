package chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

//继承classloader
public class UnloadClass extends ClassLoader implements Opcodes{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//定义一个叫做Example的类  
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_7,Opcodes.ACC_PUBLIC , "Example", null, "java/lang/Object", null);
		//生成默认构造方法
		MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		//生成构造方法的字节码指令
		mw.visitVarInsn(ALOAD, 0);
		mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(1, 1);
		mw.visitEnd();
		//生成main方法
		mw = cw.visitMethod(ACC_PUBLIC+ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		//生成main方法中的字节码指令
		mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mw.visitLdcInsn("hello world");
		mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(2, 2);
		//字节码生成完成
		mw.visitEnd();
		byte[] code = cw.toByteArray();
		for(int i=0;i<10;i++){
			UnloadClass loader = new UnloadClass();
			Method m = ClassLoader.class.getDeclaredMethod("defineClass", String.class,byte[].class,int.class,int.class);
			m.setAccessible(true);
			m.invoke(loader, "Example",code,0,code.length);
			//Class<?> exampleClass = loader.defineClass("Example", code, 0, code.length);  
			m.setAccessible(false);
			System.gc();
		}
	}

}
