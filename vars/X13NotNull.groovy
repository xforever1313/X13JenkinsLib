/// \brief - If the given object is null, this will fail the build.
///          this is useful to ensure parameters were specified or not.
///
/// \param objToCheck - If this is null, the build will fail.
/// \param objName - The name of the object.  Usually the value passed
///                  into here is the parameter name being checked.
void call( Object objToCheck, String objName = null )
{
    if( objToCheck == null )
    {
        if( objName == null )
        {
            error "${objName} can not be null";
        }
        else
        {
            error "Value can not be null";
        }
    }
}