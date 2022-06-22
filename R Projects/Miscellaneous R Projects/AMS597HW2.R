#1
intTest <- function(integer_input) {
  bool = TRUE
  if (integer_input %% 1 == 0) {
    bool = TRUE
  }
  else {
    bool = FALSE
  }
  return(bool)
}
intTest(4)
intTest(4.5)

#2a
sample(c("x1", "x2", "x3", "x4"), 50, replace = TRUE, prob = c(.1, .2, .3, .4))
#2b
x = runif(50)
v = c() #Empty random vector
for(i in x) {
  if(i < .1) {
    v = c(v, "x1")
  }
  if(i >= 0.2 && i < 0.3) {
    v = c(v, "x2")
  }
  if(i >= 0.3 && i < 0.4) {
    v = c(v, "x3")
  }
  if (i >= .4) {
    v = c(v, "x4")
  }
}
v
#3a
exp = rexp(100, rate = 2)
exp
plot(ecdf(exp))
#3b
my.plot.ecdf <- function(x) {
  len_x = length(x)
  return(plot(sort(x), (1:len_x)/len_x,type = "s"))
}
my.plot.ecdf(exp)

#4a
my_data = read.table(file = "http://www.ams.sunysb.edu/~pfkuan/Teaching/AMS597/Data/d_logret_6stocks.txt", header = TRUE)
t.test(my_data$AmerExp, mu = 0)
#High p-value (.8516), so we fail to reject the null hypothesis that its mean log return is 0.
#4b)
wilcox.test(my_data$AmerExp)
#High p-value (.3225), so we fail to reject the null hypothesis that its mean log return is 0.
#4c
t.test(my_data$Pfizer, my_data$AmerExp, mu = 0)
#High p-value (.318), so we fail to reject the null hypothesis that their means are the same (equal to o).
#4d
var(my_data$Pfizer) 
var(my_data$AmerExp)
#More variance in the data for AmerExp than in Pfizer.
#4e
wilcox.test(my_data$Pfizer, my_data$AmerExp)
#High p-value (.1662), so we fail to reject the null hypothesis that that their means are the same (equal to o).

#5
my.t.test <- function(x, y = NULL, alternative = c("less", "greater", "two_sided"), mu = 0){
  if (is.null(y)){                              
    avg_x = mean(x) 
    s_x = sd(x) 
    n_x = length(x) 
    d_f = n_x - 1 
    t_val = (avg_x - mu)/(s_x/sqrt(n_x))
    if (alternative == "less"){ 
      p_val = pt(abs(t_val), d_f)
    }
    else if (alternative == "greater"){
      p_val = 1 - pt(abs(t_val), d_f)
    }
    else{ 
      p_val = 2 * pt(-abs(t_val), d_f)
    }
  }
  else{ 
    avg_x = mean(x) 
    avg_y = mean(y) 
    s_x = sd(x) 
    s_y = sd(y)
    n_x = length(x) 
    n_y = length(y) 
    if(var.test(x, y)$p.value <= 0.05){ 
      t_val = ((avg_x - avg_y) - mu) / (sqrt((s_x^2)/n_x + (s_y^2)/n_y))
      d_f = ((s_x^2)/n_x + (s_y^2)/n_y)^2 / ((s_x^2/n_x)^2/(n_x - 1) + (s_y^2/n_y)^2/(n_y - 1))
      if(alternative == "less"){ 
        p_val = pt(abs(t_val), d_f)
      }
      else if(alternative == "greater"){ 
        p_val = 1 - pt(abs(t_val), d_f)
      }
      else{
        p_val = 2 * pt(-abs(t_val), d_f)
      }
    }
    else{
      d_f = n_x+n_y-2
      s_p = sqrt(((n_x - 1) * (s_x^2) + (n_y - 1) * (s_y^2))/(d_f)) 
      t_val = ((avg_x - avg_y) - mu)/(s_p * sqrt((1/n_x) + (1/n_y)))
      if(alternative == "less"){
        p_val = pt(abs(t_val), d_f)
      }
      else if(alternative == "greater"){ 
        p_val = 1 - pt(abs(t_val), d_f)
       
      }
      else{
        p_val = 2*pt(-abs(t_val), d_f)
      }
    }
  }
  info = c(t_val, d_f, p_val)
  return(info)
}
my.t.test(my_data$Pfizer, my_data$AmerExp, "two_sided", 0)
my.t.test(my_data$AmerExp, NULL, "two_sided")

#6
my.wilcox.test <- function(x, y){
  n_1 = length(x)
  n_2 = length(y)
  n_sum = n_1 + n_2
  w_1 = sum(rank(c(x, y))[1 : n_1]) 
  w_2 = sum(rank(c(x, y))[(n_1 + 1):(n_1 + n_2)]) 
  type = ""
  if(n_1 >= 12 & n_2 >= 12){
    exp = n_1 * (n_sum + 1)/2
    var = n_1 * n_2  *(n_sum + 1)/12
    z_val = (w_1 - exp)/sqrt(var)
    p_val = 2 * pnorm(-abs(z_val))
    type = "Normal Test"
  }
  else{ 
    rank_sum = c() 
    ranking1 = combn(rank(c(x, y)), n_1) 
    for (i in 1:choose(n_sum, n_1)){ 
      rank_sum[i] = sum(ranking1[,i])
    }
    p_val1 = length(rank_sum[rank_sum <= w_1])/length(rank_sum)
    
    rank_sum = c()
    ranking2 = combn(rank(c(x, y)), n_2) #
    for(i in 1:choose(n_sum, n_2)){
      rank_sum[i] = sum(ranking2[,i])
    }
    p_val2 = length(rank_sum[rank_sum <= w_2])/length(rank_sum)
    p_val = 2*min(p_val1, p_val2)
    type = "Exact Test"
  }
  info = c(w_1, w_2, p_val, type)
  return(info)
}
my.wilcox.test(my_data$Pfizer, my_data$AmerExp)

#7
set.seed(123)
xe = rnorm(50)
ye = 2*xe+rnorm(50)
prod = c()
for (i in 1:length(xe)) {
  prod[i] = xe[i] * ye[i] 
}
beta = sum(prod)/sum(xe^2)
beta
plot(xe, ye)
abline(lm(ye~xe), col='red')
#6c
reg <- lm(ye ~ 0 + xe)
summary(reg)

#8
set.seed(123)
a = rank(rnorm(50))
b = rank(2*a+rnorm(50))
cpairs = 0
dpairs = 0
for (i in 1:length(a)) {
  for (j in 1:length(a)) {
    if ((a[i]-a[j])*(b[i]-b[j]) > 0) {
      cpairs = cpairs + 1
    }
    else if ((a[i]-a[j])*(b[i]-b[j]) < 0) {
      dpairs = dpairs + 1
    }
  }
}
ag = ((cpairs/2)-(dpairs/2))/(length(a)*(length(a)-1)/2)
ag





