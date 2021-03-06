## Unevaluated

```
Unevaluated(expr)
```

> temporarily leaves `expr` in an unevaluated form when it appears as a function argument.
 
	
### Examples

Unevaluated is automatically removed when function arguments are evaluated:

```
>> Sqrt(Unevaluated(x))
Sqrt(x)

>> Length(Unevaluated(1+2+3+4))
4
```

Unevaluated has attribute `HoldAllComplete`:

```
>> Attributes(Unevaluated)
{HoldAllComplete,Protected}
```

Unevaluated is maintained for arguments to non-executed functions:

```
>> f(Unevaluated(x))
f(Unevaluated(x))
```

Likewise, its kept in flattened arguments and sequences:

```
>> Attributes(f) = {Flat};

>> f(a, Unevaluated(f(b, c)))
f(a,Unevaluated(b),Unevaluated(c))

>> g(a, Sequence(Unevaluated(b),Unevaluated(c)))
```

However, unevaluated sequences are kept:

```
>> g[Unevaluated[Sequence[a, b, c]]]
g(a,Unevaluated(b),Unevaluated(c))
```