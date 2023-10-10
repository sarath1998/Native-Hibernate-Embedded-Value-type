# Native-Hibernate-Embedded-Value-type
Simple Native hibernate application to show Embedded Value type

This application contains

1 Entity -- Employee.java
1 Embedded value type included in this Entity -- Address.java

@Embedded -- The dictionary meaning says "included". Where to mention this?

Now, which is included  -- the embedded field is included
     where it's included -- Inside the entity..

So, simply mention on the top of that field. 

@Embeddable --- The dictionart meaning, "includable". Where to mention this?

Now which is includable --  the Address.java in this example
    Where to mention -- Inside the embeddable class.

@AttributeOverrides -- Annotation used to give the column names dynamically specific to each instance when a common embeddable type is being shared across multiple entities.

To ignore a field from being part of the table... then @Transient annotation can be used.

For eg: 
@Transient is declared on the top of the city field in the Address.java file. Which will work as below :

tells the JPA provider to exclude the attribute from database mapping entirely. This means that the city attribute won't be stored in the database, 
and it won't be available for queries or mappings in other entities.

Note: @Transient will not block the user from setting the values to that respective field or do any manipulations on that field. It simply
will not be converted into the column in the DB.

The field can be used as similar to the other field. 

In the code, i initialized the Address instance including the city field.

Cons with @Transient:

But when other entity comes into picture which expectes the city column by trying to use the same Address instance.. then it becomes
deadlock. (If different entities need to use the Address class with different sets of attributes (some needing city and others not), 
you should consider alternative approaches to model this situation:

Use Inheritance: Create subclasses of Address with additional attributes, including city, if needed. Each entity that uses Address can then choose the 
appropriate subclass to include the desired attributes.

Create a Separate Embedded Type: Instead of using a single Address class for multiple entities, consider creating separate embedded value types tailored 
to the needs of each entity. This way, you can have different embedded types with different sets of attributes.

Include All Attributes and Ignore Unused Ones: Another option is to include all attributes in the Address class and simply ignore unused ones in the 
entities where they are not needed. While this may lead to some unused columns in the database, it can simplify your code and maintain consistency 
in the Address class.

The choice among these options depends on your specific application requirements and the flexibility you need in handling different sets of 
attributes for the Address class across different entities.
