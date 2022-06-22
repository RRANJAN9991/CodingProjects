#1a
weight <- c(60, 72, 34, 56, 87, 80, 89, 95, 76, 28, 48, 59)
weight
#1b
mean(weight)
mean(weight^2)
#1c
length(weight)
#1d
length(weight[weight>55])
#1e
yesno <- rep(NA,length(weight))
for (i in 1:length(weight)) {
  if (weight[i] > 55 && weight[i] <85) {
    yesno[i] <- "Yes" 
  }
  else {
    yesno[i] <- "No"
  }
}
yesno

#2a
tmp <- matrix(rnorm(12), 3, 4)
tmp
tmp[,1] + tmp[,3]
#2b
tmp[1,] * tmp[3]
#2c
dim(tmp)
#2d
cat(tmp[1,][tmp[1,] > 0.5])

#3
test1 <- c(3, NA, 3, 5, NA, NA)
test2 <- c(3, NA, 3, 5, NA, NA)
length(test1) == length(test2) && all(is.na(test1) == is.na(test2)) && all(test1[!is.na(test1)] == test2[!is.na(test2)])

#4
originalvec <- c(1, 2, 3, 3, 3, 4)
x <- factor(originalvec)
y <- c(22, 24, 26, 28)
y[x]

#5
myMedium.cal <- function(medianvec) {
  medianvec = sort(medianvec)
  median_num = 0
  if (length(medianvec) %% 2 != 0) {
    median_num = medianvec[(length(medianvec)+1)/2]
  }
  else {
    median_num = (medianvec[(length(medianvec)/2)+1] + medianvec[length(medianvec)/2])/2
  }
  return(median_num)
}
myMedium.cal(c(9, 10, 18, 13, 13, 24, 15, 15, 16, 16, 12, 22, 23, 24, 13, 25))

#6a
mydna <- paste(sample(c("a","t","c","g"),1000,replace=T),collapse="")
dnaFunction1 <- function(mydna) {
  cgcounter = 0
  tacounter = 0
  for (i in 1:nchar(mydna)) {
    if (substring(mydna, i, i + 1) == "cg") {
      substring(mydna, i, i + 1) = "XY"
      cgcounter = cgcounter + 1
    }
    else if (substring(mydna, i, i + 1) == "ta") {
      substring(mydna, i, i + 1) = "AB"
      tacounter = tacounter + 1
    } 
  }
  information = c(cgcounter, tacounter, mydna)
  return(information)
}
dnaFunction1(mydna)

#6b
mydna <- paste(sample(c("a","t","c","g"),1000,replace=T),collapse="")
dnaFunction2 <- function(mydna) {
cgcounter = str_count(mydna, pattern = "cg")
tacounter = str_count(mydna, pattern = "ta")
cgreplace = str_replace_all(mydna, "cg", "XY")
tareplace = str_replace_all(cgreplace, "ta", "AB")
information = c(cgcounter, tacounter, tareplace)
return(information)
}
dnaFunction2(mydna)

#7
my_data <- read.table("http://www.ams.sunysb.edu/~pfkuan/Teaching/AMS597/Data/PhoneNumber.txt", sep = "\n")
noparenthesis = grep("^[[0-9]{3}[-||.|| ][0-9]{3}[-||.|| ][0-9]{4}$", my_data[,1], perl=TRUE, value=TRUE)
parenthesis = grep("^[(][[0-9]{3}[)][-||.|| ][0-9]{3}[-||.|| ][0-9]{4}$", my_data[,1], perl=TRUE, value=TRUE)
phonenum = c(noparenthesis, parenthesis)
phonenum

#8
my_data <-  read.table("http://www.ams.sunysb.edu/~pfkuan/Teaching/AMS597/Data/d_logret_6stocks.txt")
my_data = my_data[-c(1),]
tib = as_tibble(my_data)
tib1 = rename(tib, Date = V1, Pfizer = V2, Intel = V3, Citigroup = V4, AmerExp = V5, Exxon = V6, GenMotor = V7)
tib2 = tib1 %>% mutate(Pfizer = as.double(Pfizer), Intel = as.double(Intel), Citigroup = as.double(Citigroup), AmerExp = as.double(AmerExp), Exxon = as.double(Exxon), GenMotor = as.double(GenMotor))
tib3 = tib2 %>% filter(grepl("^[1-3]-Apr-0[1-5]$", Date))
tib4 =  tib2 %>% filter(grepl("^[1-3]-May-0[1-5]$", Date))
tib5 = tib2 %>% filter(grepl("^[1-3]-Jun-0[1-5]$", Date))
tib6 = rbind(tib3, tib4, tib5)
tib6
tib7 = tib6 %>% rowwise() %>% mutate(ExxonGenMotor = mean(c(Exxon, GenMotor)))
tib7
tib8 = tib7 %>% mutate(Date = as.Date(Date, "%d-%b-%y"))
tib9 = tib8 %>% arrange(Date)
tib2001 = tib9 %>% filter(Date <= as.Date("2002-01-05"))
median2001 = median(tib2001$ExxonGenMotor)
median2001
tib2002 = tib9 %>% filter(Date >= as.Date("2002-01-05") && Date <= as.Date("2003-01-05"))
median2002 = median(tib2002$ExxonGenMotor)
median2002
tib2003 = tib9 %>% filter(Date >= as.Date("2003-01-05") && Date <= as.Date("2004-01-05"))
median2003 = median(tib2003$ExxonGenMotor)
median2003
tib2004 = tib9 %>% filter(Date >= as.Date("2004-01-05") && Date <= as.Date("2005-01-05"))
median2004 = median(tib2004$ExxonGenMotor)
median2004
tib2005 = tib9 %>% filter(Date >= as.Date("2005-01-05"))
median2005 = median(tib2005$ExxonGenMotor)
median2005



