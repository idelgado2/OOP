/*
 * The classes Cube, Sphere, Cylinder, and Glome must implement this interface.
 */

public interface Volume
{
	/**
	 * @return the volume of a shape. The type is double so there won't be type casting issues with the Java Math library. 
	 */
    double getVolume();
}